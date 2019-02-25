package JDBC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter writer = new FileWriter("names.txt",true);
			BufferedWriter bwr = new BufferedWriter(writer); // reading and writing will be fast thats y we are using buffered reader
			// 
			bwr.write("james");
			bwr.newLine();
			bwr.write("hobert");
			bwr.close();
			
			System.out.println("successfully written to a file");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
