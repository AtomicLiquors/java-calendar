package ateamproject.Data;

import java.sql.Date;


public class CalSchedBean {
	
	private int sc_id;
	private String sc_title;
	private Date sc_startdate;
	private Date sc_enddate;
	private String sc_content;
	private Boolean sc_isdone;
	private String sc_privacy;
	private int sc_priority;
	private String sc_color;
	
	
	public CalSchedBean() {
		
	}
	
	
	public CalSchedBean(int sc_id, String sc_title, Date sc_startdate, Date sc_enddate, String sc_content,
			Boolean sc_isdone, String sc_privacy, int sc_priority, String sc_color) {
		this.sc_id = sc_id;
		this.sc_title = sc_title;
		this.sc_startdate = sc_startdate;
		this.sc_enddate = sc_enddate;
		this.sc_content = sc_content;
		this.sc_isdone = sc_isdone;
		this.sc_privacy = sc_privacy;
		this.sc_priority = sc_priority;
		this.sc_color = sc_color;
	}
	
	public int getSc_id() {
		return sc_id;
	}
	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}
	public String getSc_title() {
		return sc_title;
	}
	public void setSc_title(String sc_title) {
		this.sc_title = sc_title;
	}
	public Date getSc_startdate() {
		return sc_startdate;
	}
	public void setSc_startdate(Date sc_startdate) {
		this.sc_startdate = sc_startdate;
	}
	public Date getSc_enddate() {
		return sc_enddate;
	}
	public void setSc_enddate(Date sc_enddate) {
		this.sc_enddate = sc_enddate;
	}
	public String getSc_content() {
		return sc_content;
	}
	public void setSc_content(String sc_content) {
		this.sc_content = sc_content;
	}
	public Boolean getSc_isdone() {
		return sc_isdone;
	}
	public void setSc_isdone(Boolean sc_isdone) {
		this.sc_isdone = sc_isdone;
	}
	public String getSc_privacy() {
		return sc_privacy;
	}
	public void setSc_privacy(String sc_privacy) {
		this.sc_privacy = sc_privacy;
	}
	public int getSc_priority() {
		return sc_priority;
	}
	public void setSc_priority(int sc_priority) {
		this.sc_priority = sc_priority;
	}
	
	public String getSc_color() {
		return sc_color;
	}
	public void setSc_color(String sc_color) {
		this.sc_color = sc_color;
	}
	
	

}

