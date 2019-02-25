package JDBC;
import java.sql.*;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		Statement stmt;
		ResultSet rs;
		int cnt=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.jdbc.Driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/classicmodels", "root", "nikita@1234");
			String sql = "Delete from offices where city ='Greater Nodia'";
			System.out.println(" ");
			stmt = con.createStatement();
			cnt = stmt.executeUpdate(sql);
			
			if(cnt>0)
			{
				System.out.println("Record Deleted");
			}
			con.close();
	}catch(Exception ce)
		{
		System.out.println(ce);
		}

}
}
