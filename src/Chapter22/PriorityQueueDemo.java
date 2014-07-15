package Chapter22;

import java.util.*;

public class PriorityQueueDemo {

	//PriorityQueue Class
	public static void main(String[] args){
		
		PriorityQueue<String> queue = new PriorityQueue<String>();
		
		queue.offer("Dallas");
		queue.offer("Houston");
		queue.offer("Austin");
		queue.offer("Texas");
		
		System.out.println("Priority queue using Comparable: ");
		while(queue.size() > 0)
			System.out.println(queue.remove() + " ");
		
		PriorityQueue<String> queue2 = new PriorityQueue<String>(4, 
				Collections.reverseOrder()); //Collections.reverseOrder() return a Comparator
		
		queue2.offer("Dallas");
		queue2.offer("Houston");
		queue2.offer("Austin");
		queue2.offer("Texas");
		
		System.out.println("Priority queue using Comparator: ");
		while(queue2.size() > 0)
			System.out.println(queue2.remove() + " ");
	}
}
