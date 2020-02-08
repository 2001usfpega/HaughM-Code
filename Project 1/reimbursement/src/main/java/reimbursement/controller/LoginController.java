package reimbursement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import reimbursement.model.UserBean;
import reimbursement.service.UserDBLogic;

public class LoginController {
	
	final static Logger LOG = Logger.getLogger(LoginController.class);

	public static String login(HttpServletRequest req) {
		
		String uname = req.getParameter("username");
		String pword = req.getParameter("password");
		System.out.println(uname);
		if(UserDBLogic.getDB().checkLogin(uname, pword)){
			HttpSession session = req.getSession();
			UserBean cuser = UserDBLogic.getDB().getUserFromName(uname);
			session.setAttribute("currentUser", cuser);
			if(cuser.getUsertype() == 1) {
				LOG.info("Manager: " +uname+" LOGGEDIN");
			}else {
			LOG.debug("Employee: " +uname+" LOGGEDIN");
			}
			return "Home.do";
		}
		LOG.info("Loggin failed: " +uname);
		return "Login.html";
	}

}
