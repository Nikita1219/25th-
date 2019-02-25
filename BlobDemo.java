package JDBC; //code of file handling and jdbc 

import java.io.*;
import java.sql.*;

public class BlobDemo {
	Connection con;
	PreparedStatement pstmt ;
	ResultSet rs;
	
	void createConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.jdbc.Driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mysqljdbc", "root", "nikita@1234");
			
	} catch(Exception e)
		{
		System.out.println(e);
		}
	}
	public void writeBlob(int candidateId, String filename) {
	//update 
	String updateSQL = "UPDATE candidates SET resume = ? Where id = ?";
	try {
		pstmt = con.prepareStatement(updateSQL);
		
		//read the file 
		File file = new File(filename);
		FileInputStream input = new FileInputStream(file);
		
		//set parameters 
		pstmt.setBinaryStream(1,  input);
		pstmt.setInt(2,  candidateId);
		
		//store the resume file in database 
		System.out.println("Reading file " + file.getAbsolutePath());
		System.out.println("store file in the dataabase ");
		pstmt.executeUpdate();
		con.close();
		
	}catch(Exception e)
	{
		System.out.println("Exception is" +e);
	}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlobDemo bd1 = new BlobDemo();
		bd1.createConnection();
		bd1.writeBlob(133,"johndoe_resume.pdf");

	}

}
