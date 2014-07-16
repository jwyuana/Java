package Chapter20;

import java.util.*;
import java.io.File;

public class DirectorySize {

	public static void main(String[] args){
		System.out.println("Enter a directory or a file: ");
		Scanner input = new Scanner(System.in);
		String directory = input.nextLine();
		
		System.out.println(getSize(new File(directory)) + " bytes");
	}
	
	public static int getSize(File file){
		int size = 0;
		
		if(file.isDirectory()){
			File[] list = file.listFiles();
			for(int i=0; i<list.length; i++)
				size += getSize(list[i]);
		}
		else 
			size += file.length();
		
		return size;
	}
}
