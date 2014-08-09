package Chapter19;

import java.io.*;

public class TestObjectStream {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat"));
		output.writeUTF("Jim");
		output.writeDouble(85.5);
		output.writeObject(new java.util.Date());
		output.close();
		
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"));
		String name = input.readUTF();
		double score = input.readDouble();
		java.util.Date date = (java.util.Date)(input.readObject());  // cast
		System.out.println(name + " " + score + " " + date);
		input.close();
	}

}
