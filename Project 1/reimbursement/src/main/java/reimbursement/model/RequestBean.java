package reimbursement.model;

import java.sql.Date;

public class RequestBean {
	private int request_id;
	private int u_id_fk;
	private int request_type;
	private double ammount;
	private Date date_submited;
	private Date date_resolved;
	private int status;
	private String descript;

	public RequestBean() {
	}

	public RequestBean(int request_id, int u_id_fk, int request_type, double ammount, Date date_submited,
			Date date_resolved, int status, String descript) {
		super();
		this.request_id = request_id;
		this.u_id_fk = u_id_fk;
		this.request_type = request_type;
		this.ammount = ammount;
		this.date_submited = date_submited;
		this.date_resolved = date_resolved;
		this.status = status;
		this.setDescript(descript);
	}

	@Override
	public String toString() {
		return "RequestBean [request_id=" + request_id + ", u_id_fk=" + u_id_fk + ", request_type=" + request_type
				+ ", ammount=" + ammount + ", date_submited=" + date_submited + ", date_resolved=" + date_resolved
				+ ", status=" + status + ", descript=" + descript + "]";
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public int getU_id_fk() {
		return u_id_fk;
	}

	public void setU_id_fk(int u_id_fk) {
		this.u_id_fk = u_id_fk;
	}

	public int getRequest_type() {
		return request_type;
	}

	public void setRequest_type(int request_type) {
		this.request_type = request_type;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	public Date getDate_submited() {
		return date_submited;
	}

	public void setDate_submited(Date date_submited) {
		this.date_submited = date_submited;
	}

	public Date getDate_resolved() {
		return date_resolved;
	}

	public void setDate_resolved(Date date_resolved) {
		this.date_resolved = date_resolved;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

}
