package Chapter28;

import java.util.*;

public class WeightedNineCoin {

	public static void main(String[] args){
		// construct graph
		int[] vertices = new int[512];
		List<PriorityQueue<Edge>> queues = new ArrayList<PriorityQueue<Edge>>();
				
		for(int i=0; i<vertices.length; i++){
			vertices[i] = i;
			queues.add(getNeighbors(i));
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an nine coin H's and T's: ");
		int s = stringToNode(input.next());
		
		// Dijkstra
		int[] costs = new int[512];
		int[] parent = new int[512];
		for(int i=0; i<parent.length; i++)
			parent[i] = -1;
		
		Set<Integer> T = new HashSet<Integer>();
		T.add(s);
		while(!T.contains(511)){
			int minCost = Integer.MAX_VALUE;
			int v = -1;
			for(int u:T){
				//System.out.println(u);
				while(!queues.get(u).isEmpty() && T.contains(queues.get(u).peek().v))
					queues.get(u).remove();
				if(queues.get(u).isEmpty())
					continue;
				
				Edge e = queues.get(u).peek();
				if(costs[u] + e.weight < minCost){
					v = e.v;
					minCost = costs[u] + e.weight;
					parent[v] = u;
				}
			}
			T.add(v);
			costs[v] = minCost;
		}
		
		int node = 511;
		while(node != -1){
			printNode(node);
			System.out.println();
			node = parent[node];
		}
		
		System.out.println(costs[511]);
		
		input.close();
	}
	
	
	public static PriorityQueue<Edge> getNeighbors(int u){
		int[] bits = new int[9];
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		
		int index = 0;
		int n = u;
		while(n > 0){
			bits[index++] = n%2;
			n /= 2;
		}
		
		for(int i=0; i<bits.length; i++){
			int[] flip = bits.clone();
			int v = 0;
			int w = 0;
			
			int x = i;
			flip[x] = flip[x]^1;
			++w;
			
			x = i + 1;
			if(x < 9 && x/3 == i/3){
				flip[x] = flip[x]^1;
				++w;
			}
			
			x = i - 1;
			if(x >=0 && x/3 == i/3){
				flip[x] = flip[x]^1;
				++w;
			}
			
			x = i + 3;
			if(x < 9){
				flip[x] = flip[x]^1;
				++w;
			}
			
			x = i - 3;
			if(x >= 0){
				flip[x] = flip[x]^1;
				++w;
			}
			
			for(int j=0; j<flip.length; j++)
				v = v*2 + flip[j];
			edges.add(new Edge(u, v, w));
		}
		
		return edges;
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
