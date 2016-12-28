package Graph.minimumSpaning;

import java.util.ArrayList;
import java.util.List;

class GeneralGraph{
	int N;
	List<NodeGeneric> adjMatrix[];
	ArrayList<NodeGeneric> allEdge;
	 public GeneralGraph(int N) {
		this.N=N;
		adjMatrix=new ArrayList[N];
		for(int i=0;i<N;++i)
			adjMatrix[i]=new ArrayList<NodeGeneric>();
		allEdge=new ArrayList<NodeGeneric>();
	}
	public void addEdge(int i, int j, int weight,boolean undirected) {
		// TODO Auto-generated method stub
		NodeGeneric nodegeneric=new NodeGeneric(i, j, weight);
		adjMatrix[i].add(nodegeneric);
		if(undirected)
		   adjMatrix[j].add(nodegeneric);
		allEdge.add(nodegeneric);
		
	}
}