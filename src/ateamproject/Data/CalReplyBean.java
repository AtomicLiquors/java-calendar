package ateamproject.Data;

import java.sql.Date;


public class CalReplyBean {
	
	private String mb_id; 
	int sc_id; 
	int rp_id; 
	String rp_content; 
	Date rp_date;
	
	public CalReplyBean() {
		
	}
	

	
	public CalReplyBean(String mb_id, int sc_id, int rp_id, String rp_content, Date rp_date) {
		this.mb_id = mb_id;
		this.sc_id = sc_id;
		this.rp_id = rp_id;
		this.rp_content = rp_content;
		this.rp_date = rp_date;
	}



	public String getMb_id() {
		return mb_id;
	}



	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}



	public int getSc_id() {
		return sc_id;
	}



	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}



	public int getRp_id() {
		return rp_id;
	}



	public void setRp_id(int rp_id) {
		this.rp_id = rp_id;
	}



	public String getRp_content() {
		return rp_content;
	}



	public void setRp_content(String rp_content) {
		this.rp_content = rp_content;
	}



	public Date getRp_date() {
		return rp_date;
	}



	public void setRp_date(Date rp_date) {
		this.rp_date = rp_date;
	}
	

}

