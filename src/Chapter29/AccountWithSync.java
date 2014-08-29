package Chapter29;

import java.util.concurrent.*;

// 一个同步方法在执行之前需要加锁。对于实例方法，要给调用该方法的对象加锁。对于静态方法，要给这个类加锁。
// 如果一个线程调用一个对象上的同步实例方法（静态方法），首先给该对象（类）加锁，然后执行该方法，最后解锁。
// 在解锁之前，另一个调用那个对象（类）中方法的线程将被阻塞，直到解锁。
public class AccountWithSync {
	private static Account account = new Account();
	
	public static void main(String[] args){
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=0; i<100; i++)
			executor.execute(new AddPennyTask());
		
		executor.shutdown();
		
		while(!executor.isTerminated()){
		}
		
		System.out.println("The final balance: " + account.getBalance());
	}
	
	
	private static class AddPennyTask implements Runnable{
		public void run(){
			account.deposit(1);
		}
	}
	
	private static class Account{
		private int balance = 0;
		
		public int getBalance(){
			return balance;
		}
		
		public synchronized void deposit(int amount){
			int newBalance = balance + amount;
			try{
				Thread.sleep(5);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			
			balance = newBalance;
		}
	}
}

