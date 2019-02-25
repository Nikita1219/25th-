package JDBC;  // to read and write primitive datatype using data input and output streams 

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("fil.dat")))
				{
					dout.writeDouble(1.1);;
					dout.writeInt(55);
					dout.writeBoolean(true);
					dout.writeChar('4');
					System.out.println("Data written successfully");
				} catch(FileNotFoundException ex) {
					System.out.println("Cannot open the output file");
					return;
				}
		try(DataInputStream din = new DataInputStream(new FileInputStream("fil.dat"))) // for reading and printing
		{
			double a = din.readDouble();
			int b = din.readInt();
			boolean c = din.readBoolean();
			char d = din.readChar();
			System.out.println("Values :" + a + " " + b + " " + c + " " + d);
		} catch(FileNotFoundException e)
		{
			System.out.println("cant open the input file");
			return;
		}
	}

}
