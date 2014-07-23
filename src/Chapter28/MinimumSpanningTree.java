package Chapter28;

import java.util.*;

public class MinimumSpanningTree {

	public static void main(String[] args){
		int verticesNumber = 5;
		int root = 1;
		int totalWeight = 0;
		int[][] edges = {
				{0, 1, 2}, {0, 3, 8},
				{1, 0, 2}, {1, 2, 7}, {1, 3, 3},
				{2, 1, 7}, {2, 3, 4}, {2, 4, 5},
				{3, 0, 8}, {3, 1, 3}, {3, 2, 4}, {3, 4, 6},
				{4, 2, 5}, {4, 3, 6}
		};
		
		ArrayList<PriorityQueue<Edge>> queues = new ArrayList<>();
		int[] vertices = new int[verticesNumber];
		for(int i=0; i<vertices.length; i++){
			vertices[i] = i;
			queues.add(new PriorityQueue<Edge>());
		}
		
		for(int i=0; i<edges.length; i++){
			int u= edges[i][0];
			int v = edges[i][1];
			int weight = edges[i][2];
			queues.get(u).offer(new Edge(u, v, weight));
		}
		
		
		Set<Integer> T = new HashSet<Integer>();
		List<Edge> MST = new ArrayList<>();
		T.add(root);
		while(T.size() < verticesNumber){
			int minWeight = Integer.MAX_VALUE;
			int vertex = -1;
			Edge edge = new Edge(0, 0, 0);
			for(Integer u:T){
				while(!queues.get(u).isEmpty() && T.contains(queues.get(u).peek().v))
					queues.get(u).remove();

				if(queues.get(u).isEmpty())
					continue;
				
				Edge e = queues.get(u).peek();
				if(e.weight < minWeight && !T.contains(e.v)){
					minWeight = e.weight;
					vertex = e.v;
					edge = e;
				}
			}
			T.add(vertex);
			totalWeight += minWeight;
			MST.add(edge);
		}
		
		System.out.println(T);
		System.out.println("TotalWeight is: " + totalWeight);
		System.out.println("Root is: " + root);
		for(Edge edge:MST){
			System.out.println(edge.u + " - " + edge.v);
		}
	}
	
}


class Edge implements Comparable<Edge>{
	
	public int u, v, weight;
	
	public Edge(int u, int v, int weight){
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	
	public int compareTo(Edge e){
		if(weight > e.weight)
			return 1;
		else if(weight == e.weight)
			return 0;
		else
			return -1;
	}
	
}


