package Chapter29;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ConsumerProducer {
	private static Buffer buffer = new Buffer();
	
	public static void main(String[] args){
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		executor.shutdown();
	}
	
	private static class ProducerTask implements Runnable{
		public void run(){
			try{
				int i=1;
				while(true){
					System.out.println("Producer writes " + i);
					buffer.write(i++);
					Thread.sleep((int)(Math.random()*10000));
				}
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
	
	private static class ConsumerTask implements Runnable{
		public void run(){
			try{
				while(true){
					System.out.println("\t\t\tConsumer reads " + buffer.read());
					Thread.sleep((int)(Math.random()*10000));
				}
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
	
	private static class Buffer{
		private static final int CAPACITY = 1; // buffer size;
		private Queue<Integer> queue = new LinkedList<Integer>();
		
		private static Lock lock = new ReentrantLock();
		
		private static Condition notFull = lock.newCondition();
		private static Condition notEmpty = lock.newCondition();
		
		public void write(int val){
			lock.lock();
			try{
				while(queue.size() == CAPACITY){
					notFull.await();
				}
				queue.offer(val);
				notEmpty.signal();
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
		
		public int read(){
			int val = 0;
			lock.lock();
			try{
				while(queue.isEmpty()){
					notEmpty.await();
				}
				val = queue.poll();
				notFull.signal();
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}finally{
				lock.unlock();
				return val;
			}
		}
	}
	
}
