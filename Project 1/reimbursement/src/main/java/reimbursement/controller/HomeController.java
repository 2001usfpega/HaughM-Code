package reimbursement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import reimbursement.model.UserBean;

public class HomeController {
	public static String home(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(!(session.getAttribute("currentUser")==null)) {
			UserBean currentUser =(UserBean) session.getAttribute("currentUser");
			if(currentUser.getUsertype()==1) {
				return "AdminHome.html";
			}
			return "UserHome.html";
		}
		return "Login.html";
	}
	public static String expensetable(HttpServletRequest req) {
		return "veiw.table";
	}
}