package Chapter24;

import java.util.*;

public class HeapSort {
	
	public static void main(String[] args){
		Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		Heap<Integer> heap = new Heap<>(list);
		
		while(heap.getSize() > 0)
			System.out.print(heap.remove() + " ");
		
	}

}

class Heap<T extends Comparable<T>>{
	private ArrayList<T> list = new ArrayList<T>();
	
	public Heap(){
		
	}
	
	public Heap(T[] obj){
		for(int i=0; i<obj.length; i++)
			add(obj[i]);
	}
	
	public int getSize(){
		return list.size();
	}
	
	public void add(T elem){
		list.add(elem);
		int curr = list.size() - 1;
		int parent = (curr-1)/2;
		while(curr != 0 && list.get(parent).compareTo(list.get(curr)) > 0){
			T val = list.get(curr);
			list.set(curr, list.get(parent));
			list.set(parent, val);
			curr = parent;
			parent = (curr-1)/2;
		}
	}
	
	public T remove(){
		if(list.isEmpty())
			return null;
		
		T root = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		
		int curr = 0;
		while(curr < list.size()){
			int left = curr*2 + 1;
			int right = curr*2 + 2;
			if(list.size()-1 < left)
				break;
			else if(list.size()-1 < right){
				if(list.get(left).compareTo(list.get(curr)) < 0){
					T val = list.get(curr);
					list.set(curr, list.get(left));
					list.set(left, val);
				}
				break;
			}
			
			T min = list.get(left);
			int index = left;
			if(list.get(right).compareTo(min) < 0){
				min = list.get(right);
				index = right;
			}
			
			if(min.compareTo(list.get(curr)) > 0)
				break;
			
			list.set(index, list.get(curr));
			list.set(curr, min);
			curr = index;
		}
		
		
		return root;
	}
	
}