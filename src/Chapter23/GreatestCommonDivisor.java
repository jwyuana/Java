package Chapter23;

import java.util.*;

public class GreatestCommonDivisor {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter first integer: ");
		int m = input.nextInt();
		System.out.println("Enter second integer: ");
		int n = input.nextInt();
		
		System.out.println("The greatest common divisor is: " + gcd(m, n));
	}
	
	
	public static int gcd(int m, int n){
		if(m%n == 0)
			return n;
		
		for(int i=n/2; i>1; i--)
			if(m%i==0 && n%i==0)
				return i;
		
		return 1;
	}
	
	
	public static int gcd2(int m, int n){
		if(m%n == 0)
			return n;
		return gcd2(n, m%n);
	}
	
}
