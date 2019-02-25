package JDBC;

import java.io.BufferedReader;
import java.io.*;

public class BufferedReaderExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("D:\\nikita\\tem\\countries.txt")));
			String line="";
			while((line = br.readLine())!= null){
				System.out.println(line);
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println("file not exists or insufficient rights");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An exception occured while reading the file"); 
			e.printStackTrace();
		}

         

	}

}
