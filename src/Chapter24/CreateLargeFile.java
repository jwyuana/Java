package Chapter24;

import java.io.*;

// For External Sort

public class CreateLargeFile {

	
	public static void main(String[] args) throws Exception{
		DataOutputStream output = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("largedata.dat")));
		
		for(int i=0; i<800004; i++)
			output.writeInt((int)(Math.random() * 1000000));
		
		output.close();
		
		// display first 100 numbers
		DataInputStream input = 
				new DataInputStream(new FileInputStream("largedata.dat"));
		for(int i=0; i<100; i++)
			System.out.print(input.readInt() + " ");
		
		input.close();
	}
	
}
