package Chapter19;

import java.io.*;

public class TestDataStream {

	public static void main(String[] args) throws IOException{
		DataOutputStream output = new DataOutputStream(new FileOutputStream("temp.dat"));
		
		output.writeUTF("Jim");
		output.writeDouble(85.7);
		output.writeUTF("Herry");
		output.writeDouble(87.7);
		
		output.close();
		
		DataInputStream input = new DataInputStream(new FileInputStream("temp.dat"));
		
		System.out.println(input.readUTF() + " " + input.readDouble());
		System.out.println(input.readUTF() + " " + input.readDouble());
		
		input.close();
	}
}
