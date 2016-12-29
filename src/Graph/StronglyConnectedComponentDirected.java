package Graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class StronglyConnectedComponentDirected {
public static int[] finishingValue,parent,elementFromFinishingValue;
public static boolean[] visited;
static int tracker=0;


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N=9;
		List<Integer>[] adjacentList=UtilityGetDataPrintRoute.getGraphData(N,"StronglyConnected.txt",false);
		List<Integer>[] reverseAdjacentList=new ArrayList[N];
		int counter=0;
		for(int i=0;i<N;++i)
			reverseAdjacentList[i]=new ArrayList<Integer>();
		for(List<Integer> node:adjacentList){
			for(int n:node)
				reverseAdjacentList[n].add(counter);
		counter++;		
		}
		init(N);
		int source=0;
		for(int i=N-1;i>=0;--i)
			if(!visited[i])
				DFSwithRecursion(reverseAdjacentList,i,true );//running DFS on reverse graph
		Arrays.fill(visited, false);
		int totalConnectedComponent=0;
		for(int i=tracker-1;i>=0;--i)
		{
			int element=elementFromFinishingValue[i];
			if(!visited[element]){
				DFSwithRecursion(adjacentList, element, false);
				totalConnectedComponent++;
			}
			System.out.println();
		}
		System.out.println(totalConnectedComponent);
	
	}
	public static void init(int N){
		finishingValue=new int[N];
		visited=new boolean[N];
		parent=new int[N];
		elementFromFinishingValue=new int[N];
		Arrays.fill(parent,-1);

	}
	public static void DFSwithRecursion(List<Integer>[] adjList,int source,boolean reverse){
		if(!reverse)
			System.out.print(source+"\t");
		visited[source]=true;
		for(int adjElement:adjList[source]){
			if(!visited[adjElement]){
				
				DFSwithRecursion(adjList, adjElement,reverse);
				parent[adjElement]=source;
			}
		}
		if(reverse)
			calculateFinishingTimeAndPosition(source);
	}
	static void calculateFinishingTimeAndPosition(int source){

		finishingValue[source]=tracker;
		elementFromFinishingValue[tracker]=source;
		tracker++;
		
	}

}
