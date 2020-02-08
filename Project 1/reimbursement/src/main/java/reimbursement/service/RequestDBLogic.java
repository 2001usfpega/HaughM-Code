package reimbursement.service;

import java.sql.Date;
import java.util.List;

import reimbursement.dao.RequestPLSQLDAO;
import reimbursement.model.RequestBean;
import reimbursement.model.UserBean;

public class RequestDBLogic {
	
	static public RequestDBLogic getDB(){
		if(single == null) {
			single = new RequestDBLogic();
		}
		return single;
	}
	
	static private RequestDBLogic single;
	
	private RequestDBLogic() {}
	
	private RequestPLSQLDAO requestAccess = new RequestPLSQLDAO();
	
	public RequestBean insertRequestBean(int u_id_fk, int request_type, double ammount, Date date_submited, Date date_resolved, int status, String descript) {
		return requestAccess.insert(u_id_fk, request_type, ammount, date_submited, date_resolved, status, descript);
	}
	
	public boolean updateRequest(RequestBean request){
		return requestAccess.update(request);
	}
	
	public List<RequestBean> getRequestForUser(UserBean user){
		return requestAccess.findByUser_ID(user.getUser_id());
	}
	public List<RequestBean> getAllRequests(){
		return requestAccess.findall();
	}
	public List<RequestBean> getById(int id){
		return requestAccess.findByRequest_ID(id);
	}
}
