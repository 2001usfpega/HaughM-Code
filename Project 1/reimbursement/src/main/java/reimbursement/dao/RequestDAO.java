package reimbursement.dao;

import java.sql.Date;
import java.util.List;

import reimbursement.model.RequestBean;

public interface RequestDAO {
	List<RequestBean> findall();

	List<RequestBean> findByRequest_ID(int id);

	List<RequestBean> findByUser_ID(int id);

	List<RequestBean> findByStatus(int status);

	List<RequestBean> findBeforeDate(Date date);

	List<RequestBean> findAfterDate(Date date);

	RequestBean insert(int u_id_fk, int request_type, double ammount, Date date_submited, Date date_resolved,
			int status, String descript);

	boolean update(RequestBean requestBean);
}
