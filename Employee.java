package JDBC;
import java.io.*;

public class Employee implements java.io.Serializable{
	public String name;
	public String address;
	public transient int SSN;
	public int number;
	
	public void mailCheck()
	{
		System.out.println("mailing a check to " + name + " " + address);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
