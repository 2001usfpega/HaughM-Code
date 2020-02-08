package reimbursement.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import reimbursement.model.RequestBean;
import reimbursement.model.UserBean;
import reimbursement.service.RequestDBLogic;

public class ExpenseController {
	
	final static Logger LOG = Logger.getLogger(ExpenseController.class);
	
	public static String newExpense(HttpServletRequest req) {
		HttpSession ses = req.getSession();
		if(!(ses.getAttribute("currentUser")==null)&&!(req.getParameter("type")==null)&&!(req.getParameter("Amount")==null)&&!(req.getParameter("Description")==null)) {
			UserBean currentUser =(UserBean) ses.getAttribute("currentUser");
			RequestDBLogic.getDB().insertRequestBean(currentUser.getUser_id(), Integer.valueOf(req.getParameter("type")), Double.valueOf(req.getParameter("Amount")), Date.valueOf(LocalDate.now()), null, 0, req.getParameter("Description"));
			LOG.info("User: "+currentUser.getUname()+" ID#"+currentUser.getUser_id()+" created request");
		}
		return "EmployeeHome.table";
	}

	public static String UpdateExpense(HttpServletRequest req) {
		if(!(req.getParameter("approve")== null)&&!(req.getParameter("RequestId")==null)&&!(RequestDBLogic.getDB().getById(Integer.valueOf(req.getParameter("RequestId"))).isEmpty())) {
			UserBean currentUser =(UserBean) req.getSession().getAttribute("currentUser");
			RequestBean current = RequestDBLogic.getDB().getById(Integer.valueOf(req.getParameter("RequestId"))).get(0);
			current.setStatus(Integer.valueOf(req.getParameter("approve")));
			current.setDate_resolved(new Date(System.currentTimeMillis()));
			RequestDBLogic.getDB().updateRequest(current);
			LOG.info("Manager: "+currentUser.getUname()+" ID#"+currentUser.getUser_id()+" updated request #"+req.getParameter("RequestId"));
		}
		return "ViewExpense.do";
	}

}
