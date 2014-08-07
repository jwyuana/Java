package Chapter19;

import java.io.*;

public class Copy {

	public static void main(String[] args) throws IOException{
		if(args.length != 2){
			System.out.println("need two file name.");
			System.exit(0);
		}
		
		File srcFile = new File(args[0]);
		if(!srcFile.exists()){
			System.out.println("source file not exist.");
			System.exit(0);
		}
		
		File tarFile = new File(args[1]);
		if(tarFile.exists()){
			System.out.println("target file already exists. ");
			System.exit(0);
		}
		
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(tarFile));
		
		int r;
		int numOfBytes = 0;
		while((r = input.read()) != -1){
			output.write((byte)r);
			numOfBytes++;
		}
		
		input.close();
		output.close();
		System.out.println(numOfBytes + "bytes copied.");
	}
}
