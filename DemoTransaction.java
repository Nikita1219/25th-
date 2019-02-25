package JDBC;
import java.sql.*;

public class DemoTransaction {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Connection con;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mysqljdbc", "root", "nikita@1234");
		System.out.println("driver is loaded");
		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {
			  int i1 = (int) stmt.executeUpdate("insert into candidate_skills values(13,3)");
			  int i2 = (int) stmt.executeUpdate("update skills set name = 'ruby' where id = 8"); 
			  int i3 = (int) stmt.executeUpdate("delete from candidates where id =3");
			con.commit();
			System.out.println("Transcation is sucess");
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
				System.out.println("Transaction is failed");
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			stmt.close();
	}

}
}
