package ateamproject;

public class Insert { 
	public static void main(String[] args) { 

		java.util.Date now = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		
		System.out.println(sqlDate);
	}
}
