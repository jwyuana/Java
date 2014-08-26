package Chapter23;

import java.util.*;

public class EfficientPrimeNumbers {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Find all prime numbers <= n, enter n: ");
		int n= input.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		
		final int NUMBER_PER_LINE = 10;
		int count = 0;
		int number = 2;
		int squareRoot = 1;
		
		System.out.println("The prime numbers are \n");
		
		while(number <= n){
			boolean isPrime = true;
			
			if(squareRoot * squareRoot < number) squareRoot++;
			
			for(int k=0; k<list.size() && list.get(k)<=squareRoot; k++){
				if(number % list.get(k) == 0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime){
				count++;
				list.add(number);
				if(count % NUMBER_PER_LINE == 0)
					System.out.println(number);
				else
					System.out.print(number + " ");
			}
			
			number++;
		}
		
		System.out.println("\n" + count + "primes less than n equal to " + n);
	}
}
