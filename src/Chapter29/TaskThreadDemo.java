package Chapter29;

import java.util.*;

public class TaskThreadDemo {
	
	public static void main(String[] args){
		Runnable printA = new PrintChar('a', 100);
		Runnable printB = new PrintChar('b', 100);
		Runnable printN = new PrintNum(100);
		
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(printN);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}


class PrintChar implements Runnable {
	private char ch;
	private int times;
	
	public PrintChar(char ch, int t){
		this.ch = ch;
		times = t;
	}
	
	public void run(){
		for(int i=0; i<times; i++)
			System.out.print(ch);
	}
}

class PrintNum implements Runnable{
	private int n;
	
	public PrintNum(int num){
		n = num;
	}
	
	public void run(){
		for(int i=1; i<=n; i++)
			System.out.print(" " + i);
	}
}

