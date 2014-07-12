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
		
		System.out.println(set);                 // LinekedHashSet�������Set,������set��˳��洢
		
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext())
			System.out.print(iterator.next().toUpperCase() + " ");
		
	}
}
