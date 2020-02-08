package reimbursement.service;


import java.util.List;

import reimbursement.dao.UserPLSQLDAO;

import reimbursement.model.UserBean;

public class UserDBLogic {
	
	public static UserDBLogic getDB(){
		if(single == null) {
			single = new UserDBLogic();
		}
		return single;
	}
	
	static private UserDBLogic single;
	
	private UserPLSQLDAO userAccess = new UserPLSQLDAO();

	private UserDBLogic() {
		
	}
	
	public UserBean getUserFromId(int id) {
		List<UserBean> a = userAccess.findByUserID(id);
		if(!a.isEmpty()){
			return a.get(0);  //Presumes the unique constraint is enforced for user_id
		}
		return null;
		}
	public UserBean getUserFromName(String name) {
		List<UserBean> a = userAccess.findByUserName(name);
		if(!a.isEmpty()){
			return a.get(0);  //Presumes the unique constraint is enforced for user names
		}
		return null;
		}
	
	public boolean checkLogin(String username, String password){
		UserBean u = getUserFromName(username);
		if(!(u == null)) {
			return password.equals(u.getPword());
		}
		return false;
	}
	
	public UserBean insertUser(String uname, String pword, String firstname, String lastname, int usertype) {
		return userAccess.insert(uname, pword, firstname, lastname, usertype);
	}
	public boolean updateUser(UserBean user) {
		return userAccess.update(user);
	}
	public List<UserBean> getAllUsers(){
		return userAccess.findAll();
	}
	
}
