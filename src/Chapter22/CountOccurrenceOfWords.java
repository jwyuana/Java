package Chapter22;

import java.util.*;

public class CountOccurrenceOfWords {

	public static void main(String[] args){
		String text = "Good moring. Have a good class. " + 
				"Have a good visit. Have fun!";
		
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		
		String[] words = text.split("[ \n\t\r!.,:;?(){]");
		
		for(int i=0; i<words.length; i++){
			String key = words[i].toLowerCase();
			if(key.length() <= 0)
				continue;
			if(map.containsKey(key))
				map.put(key, map.get(key)+1);
			else
				map.put(key, 1);
		}
		
		// Get all entries into a set
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		
		for(Map.Entry<String, Integer> entry:entrySet)
			System.out.println(entry.getKey() + "\t" + entry.getValue());
	}
}
