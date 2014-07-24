package Chapter28;

import java.util.*;

public class ShortestPathDijkstra {
	
	public static void main(String[] args){
		
		int verticesNumber = 5;
		int s = 3;
		int[][] edges = {
				{0, 1, 2}, {0, 3, 8},
				{1, 0, 2}, {1, 2, 7}, {1, 3, 3},
				{2, 1, 7}, {2, 3, 4}, {2, 4, 5},
				{3, 0, 8}, {3, 1, 3}, {3, 2, 4}, {3, 4, 6},
				{4, 2, 5}, {4, 3, 6}
		};
		int[] parent = new int[verticesNumber];
		int[] costs = new int[verticesNumber];
		List<PriorityQueue<Edge>> queues = new ArrayList<>();
		
		for(int i=0; i<verticesNumber; i++){
			parent[i] = -1;
			queues.add(new PriorityQueue<Edge>());
		}
		for(int i=0; i<edges.length; i++){
			int u = edges[i][0];
			int v = edges[i][1];
			int weight = edges[i][2];
			queues.get(u).offer(new Edge(u,v,weight));
		}
		
		// Dijkstra 
		Set<Integer> T = new HashSet<>();
		T.add(s);
		while(T.size() < verticesNumber){
			int minCost = Integer.MAX_VALUE;
			int v = -1;
			for(int u:T){
				while(!queues.get(u).isEmpty() && T.contains(queues.get(u).peek().v))
					queues.get(u).remove();
				if(queues.get(u).isEmpty())
					continue;
				
				Edge edge = queues.get(u).peek();
				if(costs[u] + edge.weight < minCost){
					v = edge.v;
					minCost = costs[u] + edge.weight;
					parent[v] = u;
				}
			}
			T.add(v);
			costs[v] = minCost;
		}
		
		// Print
		System.out.println("All shortest paths from " + s + " are: ");
		for(int i=0; i<verticesNumber; i++)
			if(i != s){
				System.out.print("Shotest path to " + i + ": ");
				int j = i;
				while(parent[j] != -1){
					System.out.print(j + " ");
					j = parent[j];
				}
				System.out.print(s + ". ");
				System.out.println("cost = " + costs[i]);
			}
	}

}

