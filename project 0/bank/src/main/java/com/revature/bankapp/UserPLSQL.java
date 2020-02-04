package com.revature.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPLSQL implements UserDAO {
	
	static private UserPLSQL single;
	private UserPLSQL(){
		
	}
	
	private static String url = System.getenv("TRAINING_DB_URL");
	private static String username = "bankdb";
	private static String password = System.getenv("TRAINING_DB_PASSWORD");

		
	public static UserPLSQL getSQL() {
		if(!UserPLSQL.class.isInstance(single)){
			single = new UserPLSQL();
		}
		return single;
	}
	@Override
	public List<User> findAll() {  //builds a list of all user subclasses from the database, sorted by insertion order
		List<User> out = new ArrayList<User>();
		try{
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "Select * from userstable";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.execute();
			ResultSet rs =  ps.getResultSet();
			do {
			
			rs.next();
			switch(rs.getString("usertype")){
			case "admin":
				out.add(new SuperUser(rs.getString("username"), rs.getString("pword"), rs.getString("fullName"),rs.getInt("user_id")));
			break;
			case "customer":
				out.add(new Client(rs.getString("username"), rs.getString("pword"), rs.getString("fullName"),rs.getInt("user_id")));
			break;
			case "employee":
				out.add(new Employee(rs.getString("username"), rs.getString("pword"), rs.getString("fullName"),rs.getInt("user_id")));
			break;
			}
			
			}while(!rs.isLast());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public List<User> findById(int ... id) { //takes the ID of a user(a synthetic key) should return a list with a single user object, multiple returned objects indicate failure
		List<User> out = new ArrayList<User>();
		try {
		Connection conn = DriverManager.getConnection(url, username, password);
		for(int i: id) {
			String sql = "Select * from userstable where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, i);
			ps.execute();
			ResultSet rs =  ps.getResultSet();
				while(rs.next()) {
				switch(rs.getString("usertype")){
				case "admin":
					out.add(new SuperUser(rs.getString("username"), rs.getString("pword"), rs.getString("fullName"), rs.getInt("user_id")));
				break;
				case "customer":
					out.add(new Client(rs.getString("username"), rs.getString("pword"), rs.getString("fullName"), rs.getInt("user_id")));
				break;
				case "employee":
					out.add(new Employee(rs.getString("username"), rs.getString("pword"), rs.getString("fullName"), rs.getInt("user_id")));
				break;
					}
				}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return out;
	}

	@Override
	public List<User> findByName(String ... names) {  //finds a user by the unique attribute USERNAME, should return a list with a single user object, multiple returned items indicate some failure
		List<User> out = new ArrayList<User>();
		try {
		Connection conn = DriverManager.getConnection(url, username, password);
		for(String s: names) {
			String sql = "Select * from userstable where username = '?'";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, s);
			ps.execute();
			ResultSet rs =  ps.getResultSet();
				while(rs.next()){
				switch(rs.getString("usertype")){
				case "admin":
					out.add(new SuperUser(rs.getString("username"), rs.getString("pword"), rs.getString("fullName"), rs.getInt("user_id")));
				break;
				case "customer":
					out.add(new Client(rs.getString("username"), rs.getString("pword"), rs.getString("fullName"), rs.getInt("user_id")));
				break;
				case "employee":
					out.add(new Employee(rs.getString("username"), rs.getString("pword"), rs.getString("fullName"), rs.getInt("user_id")));
				break;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public boolean insertUser(String uname,String pword, String fullname, String type) {
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into userstable (username, pword, fullname, usertype) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, uname);
			ps.setString(2, pword);
			ps.setString(3, fullname);
			ps.setString(4, type);
			ps.execute();
			ps.close();
			conn.commit();
			conn.close();
			return true;
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO Auto-generated catch block
				return false;
			}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "Update userstable set pword='?', fullname= '?' where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getFullName());
			ps.setString(3, user.getUsername());
			ps.execute();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "delete from userstable where username = '?'";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, user.getUsername());
			ps.execute();
			ps.close();
			conn.commit();
			conn.close();
			return true;
			} catch (SQLException e) {
				return false;
			}
	}

}
