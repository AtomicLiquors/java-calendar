package ateamproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import member.DBConnectionMgr;

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
				
				System.out.println( bean.getSc_id() + "\t" + bean.getSc_content() + "\t" +
						bean.getSc_startdate() + "\t" + bean.getSc_enddate() + "\t" +
						bean.getSc_color() + "\t" + bean.getSc_priority() + "\t" + bean.getSc_privacy() + "\t" + bean.getSc_title());
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return vlist;

	}
	
	
	public void addSched() {
		
	}
	
	public void delSched() {
		
	}
	
	public void editSched() {
		
	}
}
