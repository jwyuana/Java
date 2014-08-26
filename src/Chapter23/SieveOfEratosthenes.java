package Chapter23;

import java.util.*;

public class SieveOfEratosthenes {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Find all prime numbers <= n, enter n: ");
		int n= input.nextInt();
		
		boolean[] primes = new boolean[n+1];
		
		for(int i=0; i<primes.length; i++)
			primes[i] = true;
		
		for(int k=0; k<n/k; k++)
			if(primes[k])
				for(int i=k; i<=n/k; i++)
					primes[k*i] = false;
		
		int count = 0;
		for(int i=2; i<primes.length; i++){
			if(primes[i]){
				count++;
				if(count%10 == 0)
					System.out.println(i);
				else
					System.out.print(n + " ");
			}
		}
		
		System.out.println("\n" + count + "primes less than n equal to " + n);
	}
}
