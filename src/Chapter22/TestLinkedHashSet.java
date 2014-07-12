package Chapter22;

import java.util.*;

public class TestLinkedHashSet {

	public static void main(String[] args){
		Set<String> set = new LinkedHashSet<String>();  
		
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("Beijing");
		set.add("New York");                      
		
		System.out.println(set);                 // LinekedHashSet是有序的Set,按插入set的顺序存储
		
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext())
			System.out.print(iterator.next().toUpperCase() + " ");
		
	}
}
