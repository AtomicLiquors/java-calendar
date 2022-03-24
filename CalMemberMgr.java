package ateamproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class CalMemberMgr {
	private DBConnectionMgr pool;

	
	public CalMemberMgr() {
		pool = DBConnectionMgr.getInstance();
	}
//		다른 클래스에서 쓸 때 기본양식 :	

//		CalMemberMgr mgr;
//		Vector<CalMemberBean> vlist;
//		mgr = new CalMemberMgr();
//		vlist = mgr.listMember();
		
//		System.out.println(vlist);
		
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	public Vector<CalMemberBean> listMember(){
		
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
	
	
	
	public boolean dupIdChk(String id) {
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "SELECT COUNT(*) FROM member WHERE mb_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			rs.next();
			flag = ((rs.getInt(1) != 0));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}
	
	
	
	public void signUp() {
		boolean flag = false;
		
		java.util.Date now = new java.util.Date();
		java.sql.Date sqlDateNow = new java.sql.Date(now.getTime());
		
		

//		//문자열을 sqlDate로 변환.
//		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date fd = formatter.parse("2022-05-05");
//		java.sql.Date sqlDateUser = new java.sql.Date(fd.getTime());
//		
		System.out.println("SignUp 메소드가 실행되었습니다.");
		
		/* 파라미터 전달이 확인되면, 아래 내용을 다시 되살려 주세요. */
//		try {
//			con = pool.getConnection();
//			sql = "insert into member(mb_id, mb_pwd, mb_joindate, mb_realname, mb_birthdate, mb_email) "
//					+ "values(?, ?, ?, ?, ?, ?)";
//
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, param);
//			pstmt.setString(2, param);
//			pstmt.setDate(3, sqlDateNow); 
//			pstmt.setString(4, param);
//			pstmt.setString(5, param);
//			pstmt.setString(6, param);
//			rs = pstmt.executeQuery();
//			
//			rs.next();
//			flag = ((rs.getInt(1) != 0));
//			
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			pool.freeConnection(con, pstmt, rs);
//		}

	}
	
}
