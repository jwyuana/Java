package Chapter19;

import java.io.*;

public class TestRandomAccessFile {

	public static void main(String[] args) throws IOException{
		RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw");
		
		inout.setLength(0); // clear the file to destroy the old contents
		
		for(int i=0; i<200; i++)
			inout.writeInt(i);
		
		System.out.println("file length is " + inout.length()); // display the current length of the file
		
		inout.seek(0); // move the file pointer to the beginning
		System.out.println("the first number is " + inout.readInt());
		
		inout.seek(1*4); // move the pointer to the second number
		System.out.println("the second number is " + inout.readInt());

		inout.seek(9*4); // move the pointer to the tenth number
		System.out.println("the tenth number is " + inout.readInt());
		
		inout.writeInt(555); // modify the eleventh number
		
		inout.seek(inout.length()); // move pointer to the end of the file
		inout.writeInt(999); // append a new number
		
		System.out.println("the new file length is " + inout.length());
		
		inout.seek(10*4); // move to the eleventh number
		System.out.println("the eleventh number is " + inout.readInt());
		
		inout.close();
	}
	
}
