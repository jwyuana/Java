package Chapter27;

import java.util.*;

public class NineCoinSolution {
	
	
	public static void main(String[] args){
		// construct graph
		int[] vertices = new int[512];
		List<List<Integer>> neighbors = new LinkedList<List<Integer>>();
		
		for(int i=0; i<vertices.length; i++){
			vertices[i] = i;
			neighbors.add(getNeighbors(i));
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an nine coin H's and T's: ");
		int initNode = stringToNode(input.next());
		
		LinkedList<Integer> path = bfs(neighbors, initNode);
		
		for(int elem:path){
			printNode(elem);
			System.out.println();
		}
		
		input.close();
		
	}
	
	
	private static LinkedList<Integer> getNeighbors(int node){
		int[] bits = new int[9];
		LinkedList<Integer> neighbors = new LinkedList<Integer>();
		
		int index = 0;
		while(node > 0){
			bits[index++] = node%2;
			node /= 2;
		}
		
		for(int i=0; i<bits.length; i++){
			int[] flip = bits.clone();
			int neighbor = 0;
			
			int x = i;
			flip[x] = flip[x]^1;
			
			x = i + 1;
			if(x < 9 && x/3 == i/3)
				flip[x] = flip[x]^1;
			
			x = i - 1;
			if(x >=0 && x/3 == i/3)
				flip[x] = flip[x]^1;
			
			x = i + 3;
			if(x < 9)
				flip[x] = flip[x]^1;
			
			x = i - 3;
			if(x >= 0)
				flip[x] = flip[x]^1;
			
			for(int j=0; j<flip.length; j++)
				neighbor = neighbor*2 + flip[j];
			neighbors.add(neighbor);
		}
		
		return neighbors;
	}
	
	private static int stringToNode(String str){
		int node = 0;
		for(int i=0; i<str.length(); i++)
			if(str.charAt(i) == 'T')
				node = node*2 + 1;
			else if(str.charAt(i) == 'H')
				node *= 2;
		return node;
	}
	
	private static LinkedList<Integer> bfs(List<List<Integer>> neighbors, int node){
		boolean[] isVisited = new boolean[neighbors.size()];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] parent = new int[neighbors.size()];
		for(int i=0; i<parent.length; i++)
			parent[i] = -1;
		
		queue.offer(node);
		isVisited[node] = true;
		
		while(!queue.isEmpty()){
			int u = queue.poll();
			if(u == 511)
				break;
			
			for(int v:neighbors.get(u))
				if(!isVisited[v]){
					queue.offer(v);
					isVisited[v] = true;
					parent[v] = u;
				}
		}
		
		LinkedList<Integer> path = new LinkedList<Integer>();
		int n = 511;
		do{
			path.addFirst(n);
			n = parent[n];
		}
		while(n != -1);
		
		return path;
	}
	
	private static void printNode(int node){
		int[] bits = new int[9];
		
		int index = 0;
		while(node > 0){
			bits[index++] = node%2;
			node /= 2;
		}
		
		for(int i=0; i<bits.length; i++){
			if(bits[i] == 1)
				System.out.print("T");
			else
				System.out.print("H");
			
			if((i+1)%3 == 0)
				System.out.println();
		}
	}

}
