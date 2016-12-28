package Graph.minimumSpaning;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Graph.UnionFind;



public class Kruskal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean undirected=true;
		GeneralGraph g=UtilGetData.getData("spanningtree.txt",undirected);
		
		List<NodeGeneric> list=kruskalSpanningTree(g);
		for(NodeGeneric node:list)
			System.out.println((node.u+1)+"->"+(node.v+1));
		
		
	}
public static ArrayList<NodeGeneric> kruskalSpanningTree(GeneralGraph g){
	ArrayList<NodeGeneric> spanningTree=new ArrayList<NodeGeneric>();
	UnionFind UF=new UnionFind(g.N);
	Collections.sort(g.allNodes, NodeGeneric.SORT_BY_WEIGHT);
	for(NodeGeneric node:g.allNodes){
		if(!UF.connected(node.u,node.v)){
			spanningTree.add(node);
			UF.union(node.u, node.v);
		}
	}
	
	return spanningTree;
}
 

}
