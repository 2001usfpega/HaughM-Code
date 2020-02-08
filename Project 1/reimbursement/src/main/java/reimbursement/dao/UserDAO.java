package reimbursement.dao;

import java.util.List;

import reimbursement.model.UserBean;

public interface UserDAO {
	List<UserBean> findAll();
	List<UserBean> findByUserName(String name);
	List<UserBean> findByFirstName(String name);
	List<UserBean> findByLastName(String name);
	List<UserBean> findByUserID(int ID);
	List<UserBean> findByUserType(int type);
	UserBean insert(String uname, String pword, String firstname, String lastname, int usertype);
	boolean update(UserBean userbean);
}
