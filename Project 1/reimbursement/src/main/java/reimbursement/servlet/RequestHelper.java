package reimbursement.servlet;

import javax.servlet.http.HttpServletRequest;

import reimbursement.controller.ExpenseController;
import reimbursement.controller.HomeController;
import reimbursement.controller.LoginController;

public class RequestHelper {
public static String process(HttpServletRequest req) {
		
		
	System.out.println(req.getRequestURI());
	
	switch(req.getRequestURI()) {
	case "Login.html":
	case "html/Login.html":
	case "/resources/html/Login.html":
	case "/reimbursement/resources/html/Login.html":
		return "Login.html";
	case "/reimbursement/resources/html/UpdateExpense.do":
		return ExpenseController.UpdateExpense(req);
	case "/reimbursement/resources/html/NewExpense.do":
		return ExpenseController.newExpense(req);
	case "/reimbursement/resources/html/Login.do":
		return LoginController.login(req);
	case "/reimbursement/resources/html/Home.do":
		return HomeController.home(req);
	case "/reimbursement/resources/html/MakeExpense.do":
		return "CreateExpense.html";
	case "/reimbursement/resources/html/ViewExpense.do":
		return HomeController.expensetable(req);
	default:
		System.out.println("in default case");
		return "Login.html";
	}
	
	}
}
