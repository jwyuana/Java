package Chapter26;

import java.util.*;

import sun.org.mozilla.javascript.internal.Node;

public class HuffmanCode {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a text: ");
		String text = input.nextLine();
		
		int[] counts = getCharacterFrequency(text);
		
		System.out.printf("%-15s%-15s%-15s%-15s\n", "ASCII Code", "CHaracter", "Frequency", "Code");
		
		Tree tree = getHuffmanTree(counts);
		String[] codes = getCode(tree.root);
		
		for(int i=0; i<codes.length; i++)
			if(counts[i] != 0)
				System.out.printf("%-15d%-15s%-15d%-15s\n", i, (char)i + "", counts[i], codes[i]);
	}
	
	
	public static String[] getCode(Tree.Node root){
		if(root == null)
			return null;
		String[] codes = new String[2*128];
		assignCode(root, codes);
		return codes;
	}
	
	private static void assignCode(Tree.Node root, String[] codes){
		if(root.left != null){
			root.left.code = root.code + "0";
			assignCode(root.left, codes);
			
			root.right.code = root.code + "1";
			assignCode(root.right, codes);
		}
		else
			codes[(int)root.element] = root.code;
	}
	
	public static Tree getHuffmanTree(int[] counts){
		Heap<Tree> heap = new Heap<Tree>();
		for(int i=0; i<counts.length; i++)
			if(counts[i] > 0)
				heap.add(new Tree(counts[i], (char)i));
		while(heap.getSize() > 1){
			Tree t1 = heap.remove();
			Tree t2 = heap.remove();
			heap.add(new Tree(t1,t2));
		}
		
		return heap.remove();
	}
	
	public static int[] getCharacterFrequency(String text){
		int[] counts = new int[256];  // 256 ASCII characters
		
		for(int i=0; i<text.length(); i++)
			counts[(int)text.charAt(i)]++;
		
		return counts;
	}
	
	
	public static class Tree implements Comparable<Tree>{
		Node root;
		
		public Tree(Tree t1, Tree t2){
			root = new Node();
			root.left = t1.root;
			root.right = t2.root;
			root.weight = t1.root.weight + t2.root.weight;
		}
		
		public Tree(int weight, char element){
			root = new Node(weight, element);
		}
		
		public int compareTo(Tree o){
			if(root.weight < o.root.weight) 
				return -1;
			else if(root.weight == o.root.weight)
				return 0;
			else
				return 1;
		}
		
		public class Node{
			char element;
			int weight;
			Node left;
			Node right;
			String code = "";
			
			public Node(){
				
			}
			
			public Node(int weight, char element){
				this.weight = weight;
				this.element = element;
			}
		}
	}
	
	
}


class Heap<T extends Comparable>{
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
