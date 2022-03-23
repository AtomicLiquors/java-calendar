package ateamproject;

import java.sql.Date;

public class CalMemberBean {
	
	private String mb_id;
	private String mb_pwd;
	private Date mb_joindate;
	private String mb_realname;
	private Date mb_birthdate;
	private String mb_email;
	

	

	public CalMemberBean(String mb_id, String mb_pwd, Date mb_joindate, String mb_realname, Date mb_birthdate,
			String mb_email) {
		this.mb_id = mb_id;
		this.mb_pwd = mb_pwd;
		this.mb_joindate = mb_joindate;
		this.mb_realname = mb_realname;
		this.mb_birthdate = mb_birthdate;
		this.mb_email = mb_email;
	}


	public CalMemberBean() {
		
	}


	public String getMb_id() {
		return mb_id;
	}


	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}


	public String getMb_pwd() {
		return mb_pwd;
	}


	public void setMb_pwd(String mb_pwd) {
		this.mb_pwd = mb_pwd;
	}


	public Date getMb_joindate() {
		return mb_joindate;
	}


	public void setMb_joindate(Date mb_joindate) {
		this.mb_joindate = mb_joindate;
	}


	public String getMb_realname() {
		return mb_realname;
	}


	public void setMb_realname(String mb_realname) {
		this.mb_realname = mb_realname;
	}


	public Date getMb_birthdate() {
		return mb_birthdate;
	}


	public void setMb_birthdate(Date mb_birthdate) {
		this.mb_birthdate = mb_birthdate;
	}


	public String getMb_email() {
		return mb_email;
	}


	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}

	
	

//	첫 번째 목표 : 집어넣고, 출력까지.
//	두 번째 목표 : 벡터에 넣고, 벡터 출력.
}
