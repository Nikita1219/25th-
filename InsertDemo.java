package JDBC;
import java.sql.*;

public class InsertDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.jdbc.Driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels", "root", "nikita@1234");
			String str = "insert into offices values('9','Greater Nodia','+91 650 3456','Mg Road','Utility Building','KA','INDIA','56001','NA')";
			stmt = con.createStatement();
			int rowcount = stmt.executeUpdate(str);
			if(rowcount>0)
			{
				System.out.println("Record Inserted Sucessfully");
			}
			String str1= "select count(officeCode) from offices";
			rs = stmt.executeQuery(str1);
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			System.out.println("Total no of records is :"+cnt);
			con.close();
			}catch(Exception e)
			{
				System.out.println(e);
			}
	}

}
