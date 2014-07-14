package Chapter22;

import java.util.*;

public class SetListPerformanceTest {

	public static void main(String[] args){
		
		Collection<Integer> set1 = new HashSet<Integer>();
		System.out.println("Time for hash set is: " + 
		getTestTime(set1, 500000) + "ms.");
		
		Collection<Integer> set2 = new TreeSet<Integer>();
		System.out.println("Time for tree set is: " + 
		getTestTime(set2, 500000) + "ms.");
		
		Collection<Integer> set3 = new LinkedHashSet<Integer>();
		System.out.println("Time for linked hash set is: " + 
		getTestTime(set3, 500000) + "ms.");
		
		Collection<Integer> list1 = new ArrayList<Integer>();
		System.out.println("Time for array list is: " + 
		getTestTime(list1, 60000) + "ms.");
		
		Collection<Integer> list2 = new LinkedList<Integer>();
		System.out.println("Time for linked list is: " + 
		getTestTime(list2, 60000) + "ms.");
	}
	
	
	public static long getTestTime(Collection<Integer> c, int size){
		
		long startTime = System.currentTimeMillis();
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<size; i++)
			list.add(i);
		
		Collections.shuffle(list);   // static methods of Collections
		
		for(int elem:list)
			c.add(elem);
		
		Collections.shuffle(list);
		
		for(int elem:list)
			c.remove(elem);
		
		long endTime = System.currentTimeMillis();
		
		return endTime-startTime;
	}
	
}
