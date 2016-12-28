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
	int[] parentsOfNode,positionInHeap;
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
			positionInHeap=new int[adjacent.size()];
			parentsOfNode=new int[adjacent.size()];

			Arrays.fill(dis, 1000);
			Arrays.fill(parentsOfNode,-1);
			dis[source]=0;
			ArrayList<Integer> allNodes=new ArrayList<Integer>();
			
			for(Map.Entry<Integer, List<Node>> m:adjacent.entrySet()){
				allNodes.add(m.getKey());
			positionInHeap[m.getKey()]=m.getKey();
			}
			for(int i=allNodes.size()/2-1;i>=0;--i)
				minHeapify(allNodes, i,allNodes.size());
			while(!allNodes.isEmpty()){
				int n=extractMin(allNodes);
				//System.out.println(n);
				for(Node adjElement:adjacent.get(n))
				{//System.out.println(adjElement.v);
					if(dis[adjElement.v]>dis[n]+adjElement.w)
						{dis[adjElement.v]=dis[n]+adjElement.w;
						parentsOfNode[adjElement.v]=n;
						decreaseKey(allNodes, positionInHeap[adjElement.v]);
						}
				}
			}
		
		
		}
		return dis;
	}
	
	public int extractMin(ArrayList<Integer> allNodes){
				int minValue=allNodes.get(0);
		
		swap(allNodes, 0, allNodes.size()-1);
		minHeapify(allNodes,0,allNodes.size()-1);
		allNodes.remove(allNodes.size()-1);
		return minValue;
	}
	public void minHeapify(ArrayList<Integer> allNodes,int parent,int size){
		
		int leftChild=parent*2+1,rightChild=parent*2+2;
		int minElement=allNodes.get(parent),pos=parent;
		if(leftChild<size&&dis[allNodes.get(pos)]>dis[allNodes.get(leftChild)]){
			pos=leftChild;
		}
		if(rightChild<size&&dis[allNodes.get(pos)]>dis[allNodes.get(rightChild)]){
			pos=rightChild;
		}
		if(pos!=parent)
		{swap(allNodes, parent, pos);
		minHeapify(allNodes, pos,size);
		}
	}
	public void decreaseKey(ArrayList<Integer> allNodes,int pos){
		int parent=(pos-1)/2;
		//System.out.println(parent+":::"+pos);
		while((parent>=0)&&dis[allNodes.get(pos)]<dis[allNodes.get(parent)]){
			swap(allNodes, parent, pos);
			pos=parent;
			parent=(pos-1)/2;
		}
	}
	public void swap(ArrayList<Integer> allNodes,int parent,int pos){
		
		int tmp=allNodes.get(parent);
		allNodes.set(parent,allNodes.get(pos));
		allNodes.set(pos,tmp );
	positionInHeap[allNodes.get(pos)]=pos;
	positionInHeap[allNodes.get(parent)]=parent;
	}
}
public class DijkstraSingleSourceShortestPath {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader=new  BufferedReader(new FileReader("dijkstra.txt"));
		String str;
		boolean undirected=false;
		Graph g=new Graph();
		while((str=reader.readLine())!=null){
			String[] coordinates=str.split(" ");
			int source=Integer.parseInt(coordinates[0]);
			int des=Integer.parseInt(coordinates[1]);
			int weight=Integer.parseInt(coordinates[2]);
			g.addEdge(source-1, des-1, weight);
			if(undirected)
			g.addEdge(des-1, source-1, weight);
			
		}
		int source=0;
		g.dijkstraShortestPath(source);
		for(int i=0;i<g.dis.length;++i)
			System.out.println(source+"->"+i+"="+g.dis[i]);
	}

}
