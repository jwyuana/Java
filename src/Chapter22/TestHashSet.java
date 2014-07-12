package Chapter22;

import java.util.*;

public class TestHashSet {

	public static void main(String[] args){
		Set<String> set = new HashSet<String>();  // Set is an interface
		
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("Beijing");
		set.add("New York");                      // Set 存不重复元素
		
		System.out.println(set);                 // HashSet是无序的Set
		
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext())
			System.out.print(iterator.next().toUpperCase() + " ");
		
	}
}
