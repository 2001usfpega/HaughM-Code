package reimbursement.controller;


import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import reimbursement.model.RequestBean;
import reimbursement.model.UserBean;
import reimbursement.service.RequestDBLogic;
import reimbursement.service.UserDBLogic;

public class TableControler {
	
	
	public static String buildUserTable(HttpServletRequest req){
		StringBuilder out = new StringBuilder();
		List<RequestBean> in= RequestDBLogic.getDB().getRequestForUser((UserBean)req.getSession().getAttribute("currentUser"));
		for(int i = 0; i<in.size();i++){
			RequestBean cur = in.get(i);
			UserBean curuser = UserDBLogic.getDB().getUserFromId(cur.getU_id_fk());
			out.append(buildInactviceLine(curuser, cur));
		}
		return out.toString();
	}
	public static String buildInactviceLine(UserBean curuser, RequestBean cur) {
		String curtype;
		switch(cur.getRequest_type()){
		case 1:
			curtype = "Lodging";
			break;
		case 2:
			curtype = "Travel";
			break;
		case 3:
			curtype = "Food";
			break;
		case 4:
		default:
			curtype = "Other";
			break;
		}
		String selectedoption;
		switch(cur.getStatus()) {
		case -1:
			selectedoption = "<option value=\"-1\" selected>Denied</option>";
			break;
		default:
		case 0:
			selectedoption = "<option value=\"0\" selected>Pending</option>";
			break;
		case 1:
			selectedoption = "<option value=\"1\" selected>aproved</option>";
			break;
		}
		
		SimpleDateFormat formater = new SimpleDateFormat("MMM'.' d yyyy");
		String resolved = (cur.getDate_resolved()==null)?"N/A":formater.format(cur.getDate_submited());
		return "<tr><td>"+
		cur.getU_id_fk()+"</td><td>"+curuser.getFirstname()
		+"</td><td>" +curuser.getLastname()+"</td><td>" 
		+curtype+"</td><td>" +cur.getAmmount()+"</td><td>" 
		+formater.format(cur.getDate_submited())+"</td><td>"
		+resolved+"</td><td><select  class=\"ui dropdown\" >"
		+selectedoption
		+"</select></td><td>"+cur.getDescript()+"</td><td>" +cur.getRequest_id()+"</td><td><input type=\"Submit\" disabled value=\"Not authorized\"></td></tr>";
	}
	public static String buildtableadmin(HttpServletRequest req) {
		StringBuilder out = new StringBuilder();
		List<RequestBean> in= RequestDBLogic.getDB().getAllRequests();
		for(int i = 0; i<in.size();i++){
			RequestBean cur = in.get(i);
			UserBean curuser = UserDBLogic.getDB().getUserFromId(cur.getU_id_fk());
			UserBean loggedin = (UserBean) req.getSession().getAttribute("currentUser");
			if(curuser.getUser_id() ==  loggedin.getUser_id()){
				out.append(buildInactviceLine(curuser, cur));
				continue;
			}
			String curtype;
			switch(cur.getRequest_type()){
			case 1:
				curtype = "Lodging";
				break;
			case 2:
				curtype = "Travel";
				break;
			case 3:
				curtype = "Food";
				break;
			case 4:
			default:
				curtype = "Other";
				break;
			}
			String selectedoption;
			switch(cur.getStatus()) {
			case -1:
				selectedoption = "<option value=\"-1\" selected>Denied</option><option value=\"0\">Pending</option><option value=\"1\">aproved</option>";
				break;
			default:
			case 0:
				selectedoption = "<option value=\"-1\">Denied</option><option value=\"0\" selected>Pending</option><option value=\"1\">aproved</option>";
				break;
			case 1:
				selectedoption = "<option value=\"-1\">Denied</option><option value=\"0\">Pending</option><option value=\"1\" selected>aproved</option>";
				break;
			}
			
			SimpleDateFormat formater = new SimpleDateFormat("MMM'.' d yyyy");
			String resolved = (cur.getDate_resolved()==null)?"N/A":formater.format(cur.getDate_submited());
			out.append("<tr><form id=\"row"+i+"\" method=\"POST\" action=\"UpdateExpense.do\"><td>"+
			cur.getU_id_fk()+"</td><td>"+curuser.getFirstname()
			+"</td><td>" +curuser.getLastname()+"</td><td>" 
			+curtype+"</td><td>" +cur.getAmmount()+"</td><td>" 
			+formater.format(cur.getDate_submited())+"</td><td>"
			+resolved+"</td><td><select  class=\"ui dropdown\" name=\"approve\" id\"approve\" form=\"row"+i+"\">"
			+selectedoption
			+"</select></td><td>"+cur.getDescript()+"</td> <input type=\"hidden\" id=\"RequestId\" form=\"row"+i+"\" name=\"RequestId\" value=\""+cur.getRequest_id()+"\"><td>" +cur.getRequest_id()+"</td><td><input type=\"Submit\"  form=\"row"+i+"\" id=\"Submit\" value=\"Submit\"></td></form></tr>");
		}
		return out.toString();
	}
	

	public static String buildPage(HttpServletRequest req){
		UserBean loggedin = (UserBean) req.getSession().getAttribute("currentUser");
		System.out.println(loggedin.getUname());
		return ((loggedin.getUsertype()==1)?buildtableadmin(req):buildUserTable(req));
		
	}
	
	
}
