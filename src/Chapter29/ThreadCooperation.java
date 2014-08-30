package Chapter29;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

import Chapter29.AccountWithSyncUsingLock.Account;

public class ThreadCooperation {
	private static Account account = new Account();
	
	public static void main(String[] args){
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();
		
		System.out.println("Thread 1\t\tTread2\t\tBalance");
	}
	
	public static class DepositTask implements Runnable{
		public void run(){
			try{
				while(true){
					account.deposit((int)(Math.random()*10) + 1);
					Thread.sleep(1000);
				}
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
	
	public static class WithdrawTask implements Runnable{
		public void run(){
			while(true){
				account.withdraw((int)(Math.random()*10) + 1);
			}
		}
	}
	
	private static class Account{
		private static Lock lock = new ReentrantLock();
		
		private static Condition newDeposit = lock.newCondition();  // create a condition.
		
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public void withdraw(int amount){
			lock.lock();
			try{
				while(balance < amount){
					System.out.println("\t\t\tWait for a deposit");
					newDeposit.await(); // 从lock对象中创建condition, 为了使用cindition 必须首先获取lock
										// await方法让线程等待并且自动释放lock， 一旦条件正确，线程重新获取lock 继续执行
				}
				balance -= amount;
				System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
		
		public void deposit(int amount){
			lock.lock();
			try{
				balance += amount;
				System.out.println("Deposit" + amount + "\t\t\t\t\t" + getBalance());
				newDeposit.signalAll();
			}finally{
				lock.unlock();
			}
		}
	}
	
}
