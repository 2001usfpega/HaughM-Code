package com.revature.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountPLSQL implements AccountDAO {
	static private AccountPLSQL single;
	private AccountPLSQL(){
		
	}
	
	private static String url = System.getenv("TRAINING_DB_URL");
	private static String username = "bankdb";
	private static String password = System.getenv("TRAINING_DB_PASSWORD");

		
	public static AccountPLSQL getSQL() {
		if(!AccountPLSQL.class.isInstance(single)){
			single = new AccountPLSQL();
		}
		return single;
	}
	@Override
	public List<Account> findAll() {
		List<Account> out = new ArrayList<Account>();
		try{
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "Select * from accounts";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.execute();
			ResultSet rs =  ps.getResultSet();
			while(rs.next()){
				sql = "Select username from [accountlookup] where AccountId = ?";
				PreparedStatement ps2 = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ps2.setInt(1, rs.getInt("AccountID"));
				ResultSet rs2 = ps2.getResultSet();
				Collection<String> temp = new ArrayList<String>();
				while(rs2.next()){
					temp.add(rs.getString("username"));
				}
				out.add(new Account(rs.getDouble("balence"),rs.getInt("AccountId"), temp));
				rs2.close();
				ps2.close();
			}
			rs.close();
			ps.close();
			conn.close();
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return out;
	}

	@Override
	public List<Account> findById(int id) {
		List<Account> out = new ArrayList<Account>();
		try{
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "Select username from accountlookup where AccountId = ?";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs =  ps.getResultSet();
			while(rs.next()) {
				double balence = rs.getInt("Balence");
				sql = "Select username from [accountlookup] where AccountId = ?";
				PreparedStatement ps2 = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ps2.setInt(1, rs.getInt("AccountID"));
				ResultSet rs2 = ps2.getResultSet();
				Collection<String> temp = new ArrayList<String>();
				while(rs2.next()){
					temp.add(rs.getString("username"));
				}
				out.add(new Account(rs.getDouble("balence"),rs.getInt("AccountId"), temp));
				rs2.close();
				ps2.close();
				out.add(new Account(balence, id, temp.toString()));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public boolean insertAccount(double openingvalue, String user) { //takes a localy made account and attempts to insert it into the remote DB
		try{
			Connection conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			String sql = "select a_id_sequence.nextval as next from dual"; //custom Account numbers are striped for consitency
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			rs.first();
			int accountID = rs.getInt("next");
			rs.close();
			ps.close();
			sql = "Insert into accounts values(?,?) ";
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, accountID);
			ps.setDouble(2, openingvalue);
			ps.execute();
			ps.close();
			sql = "Insert into accountownership(a_id_fk,u_id_fk) values(?,?)";	
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, accountID);
			ps.setInt(2, UserPLSQL.getSQL().findByName(user).get(0).getUserID());
			ps.execute();
			ps.close();
			conn.close();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateAccount(Account account) {
		try{
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "update accounts set balence = ? where AccountId = ? ";
		PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ps.setDouble(1, account.getBalance());
		ps.setInt(2, account.getAccountNumber());
		ps.execute();
		ps.close();
		sql = "select * from [accountlookup] where AccountId = ?";
		
		ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ps.setInt(1, account.getAccountNumber());
		for(User u: account.getUsers()) {
			ResultSet rs = ps.executeQuery();
			boolean found = false;
			if(rs.first()){
				do{
					if(rs.getString("username").equals(u.getUsername())) {
						found=true;
					}
					rs.next();
				}while(!rs.isAfterLast());
			}
			rs.close();
			if(!found){
				String sql2 = "insert into accountowership(u_id_FK, a_id_FK) values(?,?)";
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, u.getUserID());
				ps2.setInt(2, account.getAccountNumber());
				ps2.execute();
				ps2.close();
			}
		}
		ps.close();
		
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAccount(Account account) {
		try{
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "delete from accounts where Accountid = ?";
		PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ps.setInt(1, account.getAccountNumber());
		boolean out = ps.execute();
		
		return out;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Account> findByName(String name) {
		List<Account> out = new ArrayList<Account>();
		String sql = "select * from [accountlookup] where username = ?";
		try{
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.first()){
				while(!rs.isAfterLast()) {
				out.addAll(findById(rs.getInt("AccountID")));
				rs.next();
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return out;
	}


}
