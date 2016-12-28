package Graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class BFS extends UtilityGetDataPrintRoute {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub


int node=8;
int source=1,destination=7;
List<Integer>[] adjacentList=getGraphData(node);
int parents[]=new int[node],d[]=new int[node];

for(int i=0;i<parents.length;++i)
	parents[i]=-1;

BFS(adjacentList,source,parents,d);
	for(int i=0;i<d.length;++i)
		System.out.println(i+":"+d[i]);
	System.out.println("distance of start to destination");
	ArrayList<Integer> route=new ArrayList<Integer>();
	printRouteFromSourceToDest(source, destination, parents,route);
	route.add(destination);
	for(int i:route)
		System.out.print(i+"\t");
	}

public static void BFS(List<Integer> adjacent[],int start,int[] parents,int[] distance){
	Queue< Integer> list=new LinkedList<Integer>();
	
	list.add(start);
	boolean[] visited=new boolean[adjacent.length];
	distance[start]=0;
	visited[start]=true;
	while(!list.isEmpty()){
		int node=list.remove();
	
		for(int e:adjacent[node]){
			if(!visited[e]){
				distance[e]=distance[node]+1;
				parents[e]=node;
				visited[e]=true;
				list.add(e);
			}
		}
	}
	
}



}
