package ateamproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import member.DBConnectionMgr;

public class CalMemberMgr {
	private DBConnectionMgr pool;

	
	public CalMemberMgr() {
		pool = DBConnectionMgr.getInstance();
		
//		다른 클래스에서 쓸 때 기본양식 :	

//		CalMemberMgr mgr;
//		Vector<CalMemberBean> vlist;
//		mgr = new CalMemberMgr();
//		vlist = mgr.listMember();
		
//		System.out.println(vlist);
		
	}
	
	public Vector<CalMemberBean> listMember(){
		
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
				CalMemberBean bean 
				= new CalMemberBean(
						rs.getString("mb_id"),
						rs.getString("mb_pwd"),
						rs.getDate("mb_joindate"),
						rs.getString("mb_realname"),
						rs.getDate("mb_birthdate"),
						rs.getString("mb_email"));
				
				
				
				vlist.addElement(bean);

				System.out.println( bean.getMb_id() + "\t" + bean.getMb_pwd() + "\t" +
						bean.getMb_joindate() + "\t" + bean.getMb_realname() + "\t" +
						bean.getMb_birthdate() + "\t" + bean.getMb_email());

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	
	
	public boolean loginChk(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "select mb_id from member where mb_id = ? and mb_pwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) 
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	
	
}
