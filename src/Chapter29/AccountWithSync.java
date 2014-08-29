package Chapter29;

import java.util.concurrent.*;

// һ��ͬ��������ִ��֮ǰ��Ҫ����������ʵ��������Ҫ�����ø÷����Ķ�����������ھ�̬������Ҫ������������
// ���һ���̵߳���һ�������ϵ�ͬ��ʵ����������̬�����������ȸ��ö����ࣩ������Ȼ��ִ�и÷�������������
// �ڽ���֮ǰ����һ�������Ǹ������ࣩ�з������߳̽���������ֱ��������
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

