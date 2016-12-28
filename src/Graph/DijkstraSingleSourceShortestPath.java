package Graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node{
	int v,w;

	public Node(int v, int w) {
		super();
		this.v = v;
		this.w = w;
	}
	
}
class Graph{
	
	HashMap<Integer,List<Node>> adjacent=new HashMap();
	int[] dis;
	int[] parentsOfNode;
	public Graph() {
		
	
	}
	public void addEdge(int source,int des,int weight)
	{
		if(adjacent.containsKey(source))
			adjacent.get(source).add(new Node(des, weight));
		else
		{List<Node> tempNode=new ArrayList<Node>();
		tempNode.add((new Node(des,weight)));
			adjacent.put(source,tempNode);
		}
		
	}
	
	public int[] dijkstraShortestPath(int source){
		if(adjacent.containsKey(source)){
			dis=new int[adjacent.size()];
			parentsOfNode=new int[adjacent.size()];
			Arrays.fill(dis, 1000);
			Arrays.fill(parentsOfNode,-1);
			dis[source]=0;
			ArrayList<Integer> allNodes=new ArrayList<Integer>();
			
			for(Map.Entry<Integer, List<Node>> m:adjacent.entrySet())
				allNodes.add(m.getKey());
			minHeapify(allNodes,0);
			while(!allNodes.isEmpty()){
				int n=extractMin(allNodes);
				System.out.println(n);
				for(Node adjElement:adjacent.get(n))
				{
					if(dis[adjElement.v]>dis[n]+adjElement.w)
						{dis[adjElement.v]=dis[n]+adjElement.w;
						parentsOfNode[adjElement.v]=n;
						}
				}
			}
		
		
		}
		return dis;
	}
	public int extractMin(ArrayList<Integer> allNodes){
		int minValue=allNodes.get(0);
		allNodes.set(0,allNodes.get(allNodes.size()-1));
		minHeapify(allNodes,0);
		allNodes.remove(allNodes.size()-1);
		return minValue;
	}
	public void minHeapify(ArrayList<Integer> allNodes,int parent){
		
		int leftChild=parent*2+1,rightChild=parent*2+2;
		int minElement=allNodes.get(parent),pos=parent,size=allNodes.size()-1;
		if(leftChild<size&&dis[allNodes.get(pos)]>dis[allNodes.get(leftChild)]){
			pos=leftChild;
		}
		if(rightChild<size&&dis[allNodes.get(pos)]>dis[allNodes.get(rightChild)]){
			pos=rightChild;
		}
		if(pos!=parent)
		{int tmp=allNodes.get(parent);
		allNodes.set(parent,allNodes.get(pos));
		allNodes.set(pos,tmp );
		minHeapify(allNodes, pos);
		}
	}
}
public class DijkstraSingleSourceShortestPath {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader=new  BufferedReader(new FileReader("dijkstra.txt"));
		String str;
		Graph g=new Graph();
		while((str=reader.readLine())!=null){
			String[] coordinates=str.split(" ");
			int source=Integer.parseInt(coordinates[0]);
			int des=Integer.parseInt(coordinates[1]);
			int weight=Integer.parseInt(coordinates[2]);
			g.addEdge(source-1, des-1, weight);
			
			
		}
		
		g.dijkstraShortestPath(0);
		for(int i=0;i<g.dis.length;++i)
			System.out.println("0->"+i+"="+g.dis[i]);
	}

}
