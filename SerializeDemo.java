package JDBC;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		e.name = "Micheal Khan";
		e.address = "Castle Street , Banglore";
		e.SSN = 11122333;
		e.number = 101;
		try
		{
			FileOutputStream fileout = new FileOutputStream("D:\\Eclipse\\CoreJava\\temp\\employee.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(e);
			out.close();
			fileout.close();
			System.out.println("Serialized data is save in D:\\\\Eclipse\\\\CoreJava\\\\temp\\\\employee.txt");
		} catch(IOException i)
		{
			i.printStackTrace();
		}

	}

}
