package com.revature.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountPLSQL implements AccountDAO {
	static private AccountPLSQL single;
	private AccountPLSQL(){
		
	}
	
	private static String url = System.getenv("TRAINING_DB_URL");
	private static String username = System.getenv("TRAINING_DB_USERNAME");
	private static String password = System.getenv("TRAINING_DB_PASSWORD");

		
	public static AccountPLSQL getSQL() {
		if(single.equals(null)){
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
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			ResultSet rs =  ps.getResultSet();
			do {
				rs.next();
				sql = "Select username from [accountlookup] where AccountId = ?";
				PreparedStatement ps2 = conn.prepareStatement(sql);
				ps2.setInt(1, rs.getInt("AccountID"));
				ResultSet rs2 = ps2.getResultSet();
				StringBuilder temp = new StringBuilder();
				if(rs2.first()){
					temp.append(rs.getString("username"));
					rs2.next();
				while(!rs2.isAfterLast()){
					temp.append(":"+rs.getString("username"));
					rs2.next();
				}
					out.add(new Account(rs.getDouble("balence"),rs.getInt("AccountId"), temp.toString()));
				}
				rs2.close();
				ps2.close();
			}while(!rs.isLast());
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
			String sql = "Select username from [accountlookup] where AccountId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs =  ps.getResultSet();
			if(rs.first()) {
				double balence = rs.getInt("Balence");
				StringBuilder temp = new StringBuilder();
				temp.append(rs.getString("username"));
				rs.next();
				while(!rs.isAfterLast()){
					temp.append(":"+rs.getString("username"));
					rs.next();
				}
				out.add(new Account(balence, id, temp.toString()));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public boolean insertAccount(Account account) { //takes a localy made account and attempts to insert it into the remote DB
		try{
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select  a_id_sequence.nextval from dual"; //custom Account numbers arent exactly alowed
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.first();
			account.setAcountNumber(rs.getInt(1));
			rs.close();
			ps.close();
			sql = "Insert into accounts ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(Account account) {
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "delete from accounts where Accountid";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
	}


}
