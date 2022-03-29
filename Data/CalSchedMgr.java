package ateamproject.Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import member.DBConnectionMgr;
import member.MemberBean;

public class CalSchedMgr {
	private DBConnectionMgr pool;

	public CalSchedMgr() {
		pool = DBConnectionMgr.getInstance();
	}

//	다른 클래스에서 쓸 때 기본양식 :	

//	CalSchedMgr mgr;
//	Vector<CalSchedBean> vlist;
//	mgr = new CalSchedMgr();
//	vlist = mgr.listMember();
	
//	System.out.println(vlist);
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	public Vector<CalSchedBean> listSched() {
		
		Vector<CalSchedBean> vlist = new Vector<CalSchedBean>();
		
		try {
			con = pool.getConnection();
			sql = "select * from sched";
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CalSchedBean bean 
				= new CalSchedBean(
						rs.getInt("sc_id"),
						rs.getString("sc_title"),
						rs.getDate("sc_startdate"),
						rs.getDate("sc_enddate"),
						rs.getString("sc_content"),
						rs.getBoolean("sc_isdone"),
						rs.getString("sc_privacy"),
						rs.getInt("sc_priority"),
						rs.getString("sc_color")
						);
				
				vlist.addElement(bean);
				
				System.out.println( 
						bean.getSc_id() + "\t" + 
						bean.getSc_content() + "\t" +
						bean.getSc_startdate() + "\t" + 
						bean.getSc_enddate() + "\t" +
						bean.getSc_color() + "\t" + 
						bean.getSc_priority() + "\t" + 
						bean.getSc_privacy() + "\t" + 
						bean.getSc_title());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return vlist;

	}
	
	public CalSchedBean getSched(String d) { //0.매개변수로 date를 받는다.
		CalSchedBean bean = new CalSchedBean();
		
		Date rDate = Date.valueOf(d);
		
		try {
			con = pool.getConnection();
			//between
			sql = "SELECT * FROM sched WHERE sc_startdate <= ? AND sc_enddate >= ?";//2. 물음표 자리에 매개변수가 들어가.
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, rDate); //1. 여기서 매개변수 date를 받은 다음...
			pstmt.setDate(2, rDate); 
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setSc_id(rs.getInt("sc_id"));
				bean.setSc_enddate(rs.getDate("sc_enddate"));
				bean.setSc_content(rs.getString("sc_content"));
				bean.setSc_isdone(rs.getBoolean("sc_isdone"));
				bean.setSc_priority(rs.getInt("sc_priority"));
				bean.setSc_color(rs.getString("sc_color"));
				bean.setSc_privacy(rs.getString("sc_privacy"));
				bean.setSc_startdate(rs.getDate("sc_startdate"));
				bean.setSc_title(rs.getString("sc_title"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	
	public void addSched() {
		
	}
	
	public void delSched() {
		
	}
	
	public void editSched() {
		
	}
}
