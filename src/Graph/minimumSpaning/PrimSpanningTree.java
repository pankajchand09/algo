package Graph.minimumSpaning;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;



public class PrimSpanningTree {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean undirected=true;
		GeneralGraph g=UtilGetData.getData("spanningtree.txt",undirected);
		
		PrimAlgo algo=new PrimAlgo(g, g.N);
		int source=0;
		System.out.println(algo.PrimSpanningTree(source));
/*		ArrayList<NodeGeneric> spannigTree=algo.PrimSpanningTree(source);
		for(NodeGeneric node:spannigTree)
			System.out.println((node.u+1)+"->"+(node.v+1));*/
	}
}
	class PrimAlgo{
		int[] dis,parentsOfNode,positionInHeap;
		GeneralGraph g;
		boolean[] trackingExtractedNodes;
		int N;
		ArrayList<Integer> allNodes;
		public PrimAlgo(GeneralGraph g,int N ) {
			// TODO Auto-generated constructor stub
			this.N=N;
		dis=new int[N];
		positionInHeap=new int[N];
		parentsOfNode=new int[N];
		this.g=g;
		
		}
		public int PrimSpanningTree(int source){
			int miniDis=0;
			Arrays.fill(dis, 1000);
			Arrays.fill(parentsOfNode,-1);	
			dis[source]=0;
			allNodes=new ArrayList<Integer>();
			
			for(int i=0;i<N;++i){
				allNodes.add(i);
			positionInHeap[i]=i;
			}
			for(int i=allNodes.size()/2-1;i>=0;--i)
				minHeapify(allNodes, i,allNodes.size());
			trackingExtractedNodes=new boolean[N];
			while(!allNodes.isEmpty()){
				int n=extractMin(allNodes);
				trackingExtractedNodes[n]=true;
				//System.out.println((n)+":size"+allNodes.size());
				for(NodeGeneric adjElement:g.adjMatrix[n])
				{//System.out.println("ele:"+(adjElement.v));
					if(adjElement.v!=n)
						compareWeightWithNode(n, adjElement, adjElement.v);
					else
						compareWeightWithNode(n, adjElement, adjElement.u);
						
					}
				
				
			miniDis+=dis[n];
			}
		
		return miniDis;
		}
	public void compareWeightWithNode(int n,NodeGeneric adjElement,int pos){
		
		if(!trackingExtractedNodes[pos]&&dis[pos]>adjElement.w)
		{dis[pos]=adjElement.w;
		parentsOfNode[pos]=n;
		decreaseKey(allNodes, positionInHeap[pos]);
		//spanningTreeNodes.add(adjElement);
		}
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
	
	
	

