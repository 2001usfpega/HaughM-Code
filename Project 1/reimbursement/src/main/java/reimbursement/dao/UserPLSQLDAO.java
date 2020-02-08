package reimbursement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reimbursement.model.UserBean;

public class UserPLSQLDAO implements UserDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String url = System.getenv("TRAINING_DB_URL");
	private static String username = "expensedb";
	private static String password = System.getenv("TRAINING_DB_PASSWORD");

	@Override
	public List<UserBean> findByUserName(String name) {
		String sql = "Select * from userstable where uname = ?";
		List<UserBean> out = new ArrayList<UserBean>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, name);
			out = getResultsFromPreparedStatment(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public List<UserBean> findByFirstName(String name) {
		String sql = "Select * from userstable where firstname = ?";
		List<UserBean> out = new ArrayList<UserBean>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, name);
			out = getResultsFromPreparedStatment(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public List<UserBean> findByLastName(String name) {
		String sql = "Select * from userstable where lastname = ?";
		List<UserBean> out = new ArrayList<UserBean>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, name);
			out = getResultsFromPreparedStatment(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public List<UserBean> findByUserID(int ID) {
		String sql = "Select * from userstable where user_id = ?";
		List<UserBean> out = new ArrayList<UserBean>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, ID);
			out = getResultsFromPreparedStatment(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public List<UserBean> findByUserType(int type) {
		String sql = "Select * from userstable where usertype = ?";
		List<UserBean> out = new ArrayList<UserBean>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, type);
			out = getResultsFromPreparedStatment(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public List<UserBean> findAll() {
		String sql = "Select * from userstable";
		List<UserBean> out = new ArrayList<UserBean>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			out = getResultsFromPreparedStatment(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	private List<UserBean> getResultsFromPreparedStatment(PreparedStatement ps) throws SQLException {
		List<UserBean> out = new ArrayList<UserBean>();
		ps.execute();
		ResultSet rs = ps.getResultSet();
		while (rs.next()) {
			out.add(new UserBean(rs.getInt("user_id"), rs.getString("uname"), rs.getString("pword"),
					rs.getString("firstname"), rs.getString("lastname"), rs.getInt("usertype")));
		}
		return out;
	}

	@Override
	public UserBean insert(String uname, String pword, String firstname, String lastname, int usertype) {
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select r_id_sequence.nextval as next from dual";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			rs.first();
			int user_id = rs.getInt("next");
			rs.close();
			ps.close();
			sql = "Insert into userstable (user_id, uname, pword, firstname, lastname , usertype) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, user_id);
			ps.setString(2, uname);
			ps.setString(3, pword);
			ps.setString(4, firstname);
			ps.setString(5, lastname);
			ps.setInt(6, usertype);
			ps.execute();
			ps.close();
			conn.close();
			return new UserBean(user_id, uname, pword, firstname, lastname, usertype);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(UserBean userBean) {
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "Update requests (uname, pword, firstname, lastname , usertype) values(?,?,?,?,?,?) where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, userBean.getUname());
			ps.setString(2, userBean.getPword());
			ps.setString(3, userBean.getFirstname());
			ps.setString(4, userBean.getLastname());
			ps.setInt(5, userBean.getUsertype());
			ps.setInt(6, userBean.getUser_id());
			return !(ps.executeUpdate() == 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
