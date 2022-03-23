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

	public Vector<CalMemberBean> listMember() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<CalMemberBean> vlist = new Vector<CalMemberBean>();

		
		try {
			con = pool.getConnection();
			sql = "select * from member";
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
						rs.getInt("sc_priority")
						);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}

		return vlist;

	}
}
