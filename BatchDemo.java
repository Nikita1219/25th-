package JDBC;
import java.sql.*;

public class BatchDemo {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	
	BatchDemo()
	{
	}
	
	void createConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mysqljdbc", "root", "nikita@1234");
		}catch(Exception e)
		{
			System.out.println(e);
			}
	}
		public void createBatch() throws SQLException
		{ 
			con.setAutoCommit(false);
			stmt = con.createStatement();
			stmt.addBatch("insert into skills(name) values('String')");
			stmt.addBatch("update skills Set name= 'Web App' where id = 4");
			stmt.addBatch("delete from skills where id =2");
			
	
		try {
			int i[] = stmt.executeBatch();
			con.commit();
			System.out.println("batch is sucessfully exceuted ");
			
		} catch(Exception e ) {
			con.rollback();
			System.out.println("batch is failed");
			
		}
		
}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		BatchDemo bd = new BatchDemo();
		bd.createConnection();
		bd.createBatch();
	}

}
