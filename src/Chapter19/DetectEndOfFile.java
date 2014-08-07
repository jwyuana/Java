package Chapter19;

import java.io.*;

public class DetectEndOfFile {

	public static void main(String[] args){
		try{
			DataOutputStream output = new DataOutputStream(new FileOutputStream("test.dat"));
			output.writeDouble(-4.2);
			output.writeDouble(5.4);
			output.close();
			
			DataInputStream input = new DataInputStream(new FileInputStream("test.dat"));
			
			while(true)
				System.out.println(input.readDouble());
		}catch(EOFException ex){
			System.out.println("End of File. ");
		}catch(IOException ioex){
			ioex.printStackTrace();
		}
	}
}
