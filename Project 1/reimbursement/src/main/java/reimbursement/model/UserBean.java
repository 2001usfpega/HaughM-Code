package reimbursement.model;

public class UserBean {
	private int user_id;
	private String uname;
	private String pword;
	private String firstname;
	private String lastname;
	private int usertype;

	public UserBean() {
	}

	public UserBean(int user_id, String uname, String pword, String firstname, String lastname, int usertype) {
		super();
		this.user_id = user_id;
		this.uname = uname;
		this.pword = pword;
		this.firstname = firstname;
		this.lastname = lastname;
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "UserBean [user_id=" + user_id + ", uname=" + uname + ", pword=" + pword + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", usertype=" + usertype + "]";
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
}
