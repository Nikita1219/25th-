package JDBC;
import java.sql.*;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pstmt ;
		ResultSet rs;
		int cnt=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.jdbc.Driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels", "root", "nikita@1234");
			String sqlUpdate = "UPDATE employees "+ "SET jobTitle = ? "+"where employeeNumber= ? ";
		    pstmt = con.prepareStatement(sqlUpdate);
			
			Scanner s = new Scanner(System.in);
			System.out.println("enter Employee Id:");
			
			int eid = s.nextInt(); //1702
			s.nextLine();
			System.out.println("enter new job title :");
			String strm = s.next(); //Sales Manager 
			
			pstmt.setString(1, strm); //
			pstmt.setInt(2, eid);
			
			int rowAffected = pstmt.executeUpdate();
			System.out.println("Row affected"+ rowAffected);
			
			//reuse the prepared statement 
			strm = "Sales head";
			eid = 1337;
			pstmt.setString(1, strm);
			pstmt.setInt(2, eid);
			
			rowAffected = pstmt.executeUpdate();
			System.out.println("Row affected"+ rowAffected);
			con.close();
	}catch(Exception e)
		{
		System.out.println(e);
		}
}
}
