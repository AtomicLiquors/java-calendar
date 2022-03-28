package ateamproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	
	public void signUp(String id, char[] pwd, String name, String bDate, String email) {
//		boolean flag = false;
		
		java.util.Date now = new java.util.Date();
		java.sql.Date jDate = new java.sql.Date(now.getTime());
		
		Date sbDate = Date.valueOf(bDate);
		
		String pwdStr = "";
		
		for(char c : pwd){ 
			Character.toString(c); 
		//cha 에 저장된 값 string으로 변환 
			pwdStr += (pwdStr.equals("")) ? ""+c+"" : ""+c+""; 
		//pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자 
		}
		
		

		try {
			con = pool.getConnection();
			sql = "insert into member(mb_id, mb_pwd, mb_joindate, mb_realname, mb_birthdate, mb_email) "
					+ "values(?, ?, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwdStr);
			pstmt.setDate(3, jDate); 
			pstmt.setString(4, name);
			pstmt.setDate(5, sbDate);
			pstmt.setString(6, email);
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + "명의 회원정보가 추가되었습니다.");
			
//			flag = ((rs.getInt(1) != 0));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}

	}
	
}
