package Chapter29;

import java.util.concurrent.*;

public class ExecutorDemo {

	public static void main(String[] args){
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.execute(new PrintChar('a', 100));
		executor.execute(new PrintChar('b', 100));
		executor.execute(new PrintNum(100));
		
		executor.shutdown();  // shut down: reject all new application, but will keep running current task until done
	}
}
