package Chapter22;

import java.util.*;

public class TestQueue {

	// LinkedList��ʵ����Deque�ӿڣ�Deque�ӿ�����չ��Queue�ӿ�
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
