package Chapter28;

import Chapter27.*;

public class WeightedEdge extends AbstractGraph.Edge implements Comparable<WeightedEdge>{

	public int weight;
	
	public WeightedEdge(int u, int v, int weight){
		super(u, v);
		this.weight = weight;
	}
	
	public int compareTo(WeightedEdge edge){
		if(weight > edge.weight)
			return 1;
		else if (weight == edge.weight)
			return 0;
		else
			return -1;
	}
}
