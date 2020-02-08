package reimbursement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reimbursement.model.RequestBean;

public class RequestPLSQLDAO implements RequestDAO {

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

	private List<RequestBean> getResultsFromPreparedStatment(PreparedStatement ps) throws SQLException {
		List<RequestBean> out = new ArrayList<RequestBean>();
		ps.execute();
		ResultSet rs = ps.getResultSet();
		while (rs.next()) {
			out.add(new RequestBean(rs.getInt("request_id"), rs.getInt("u_id_fk"), rs.getInt("request_type"),
					rs.getDouble("ammount"), rs.getDate("date_submited"), rs.getDate("date_resolved"),
					rs.getInt("status"), rs.getString("descript")));
		}
		return out;
	}

	@Override
	public List<RequestBean> findall() {
		String sql = "Select * from requests";
		List<RequestBean> out = new ArrayList<RequestBean>();
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

	@Override
	public List<RequestBean> findByRequest_ID(int id) {
		String sql = "Select * from requests where request_id = ?";
		List<RequestBean> out = new ArrayList<RequestBean>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, id);
			out = getResultsFromPreparedStatment(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public List<RequestBean> findByUser_ID(int id) {
		String sql = "Select * from requests where u_id_fk = ?";
		List<RequestBean> out = new ArrayList<RequestBean>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, id);
			out = getResultsFromPreparedStatment(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public List<RequestBean> findByStatus(int status) {
		String sql = "Select * from requests where status = ?";
		List<RequestBean> out = new ArrayList<RequestBean>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, status);
			out = getResultsFromPreparedStatment(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public List<RequestBean> findBeforeDate(Date date) {
		String sql = "Select * from requests where date_submited >= ?";
		List<RequestBean> out = new ArrayList<RequestBean>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setDate(1, date);
			out = getResultsFromPreparedStatment(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public List<RequestBean> findAfterDate(Date date) {
		String sql = "Select * from requests where date_submited <= ?";
		List<RequestBean> out = new ArrayList<RequestBean>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setDate(1, date);
			out = getResultsFromPreparedStatment(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public RequestBean insert(int u_id_fk, int request_type, double ammount, Date date_submited, Date date_resolved,
			int status, String descript) {
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "select r_id_sequence.nextval as next from dual";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			rs.first();
			int reqID = rs.getInt("next");
			rs.close();
			ps.close();
			sql = "Insert into requests ( request_id, u_id_fk, request_type, ammount, date_submited , date_resolved, status, descript) values(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, reqID);
			ps.setInt(2, u_id_fk);
			ps.setInt(3, request_type);
			ps.setDouble(4, ammount);
			ps.setDate(5, date_submited);
			ps.setDate(6, date_resolved);
			ps.setInt(7, status);
			ps.setString(8, descript);
			ps.execute();
			ps.close();
			conn.close();
			return new RequestBean(reqID, u_id_fk, request_type, ammount, date_submited, date_resolved, status,
					descript);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(RequestBean requestBean) {
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "Update requests (u_id_fk, request_type, ammount, date_submited , date_resolved, status, descript) values(?,?,?,?,?,?,?) where request_id=?";
			PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, requestBean.getU_id_fk());
			ps.setInt(2, requestBean.getRequest_type());
			ps.setDouble(3, requestBean.getAmmount());
			ps.setDate(4, requestBean.getDate_submited());
			ps.setDate(5, requestBean.getDate_resolved());
			ps.setInt(6, requestBean.getStatus());
			ps.setString(7, requestBean.getDescript());
			ps.setInt(8, requestBean.getRequest_id());
			return !(ps.executeUpdate() == 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
