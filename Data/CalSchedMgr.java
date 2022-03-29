package ateamproject.Data;

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
		System.out.println(d);
		System.out.println(rDate);
		
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
	
	
	public boolean addSched(CalSchedBean bean) {

		boolean flag = false;

		try {
			con = pool.getConnection();
			sql = "insert sched "
					+ "(sc_title, sc_startdate, sc_enddate,	sc_content,	sc_isdone, sc_privacy, sc_priority, sc_color)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getSc_title());
			pstmt.setDate(2, bean.getSc_startdate());
			pstmt.setDate(3, bean.getSc_enddate());
			pstmt.setString(4, bean.getSc_content());
			pstmt.setBoolean(5, bean.getSc_isdone());
			pstmt.setString(6, bean.getSc_privacy());
			pstmt.setInt(7, bean.getSc_priority());
			pstmt.setString(8, bean.getSc_color());
			// 적용된 레코드 개수 : 에러 및 처리 : 0, 정상 처리시 : 1(insert는 1이에요.)
			int cnt = pstmt.executeUpdate(); // SQL문 실행!
			if (cnt == 1)
				flag = true; // 그래서... "cnt는 1이면... flag는 true다."
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	
	public void delSched() {
		
	}
	
	public void editSched() {
		
	}
}
