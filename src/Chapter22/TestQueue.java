package Chapter22;

import java.util.*;

public class TestQueue {

	// LinkedList类实现了Deque接口，Deque接口又扩展了Queue接口
	public static void main(String[] args){
		
		Queue<String> queue = new LinkedList<String>();
		
		queue.offer("Dallas");
		queue.offer("Houston");
		queue.offer("Austin");
		queue.offer("Texas");
		
		while(queue.size()>0)
			System.out.println(queue.remove() + " ");
	}
}
