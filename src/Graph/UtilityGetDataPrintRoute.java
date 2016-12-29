package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class UtilityGetDataPrintRoute {

	public static List<Integer>[] getGraphData(int node,String file,boolean undirected) throws NumberFormatException, IOException{
		BufferedReader reader=new BufferedReader(new  FileReader(file));
		List<Integer>[] adjacentList=new LinkedList[node];
		//boolean undirected=true;
		for(int i=0;i<adjacentList.length;++i)
			adjacentList[i]=new LinkedList<Integer>();
		int parents[]=new int[node],d[]=new int[node];
		String str;
		while((str=reader.readLine())!=null){
			String[] ele=str.split(" ");
			int par=Integer.parseInt(ele[0]);

			for(int i=1;i<ele.length;++i)
					addEdge(adjacentList,par,Integer.parseInt(ele[i]),undirected );
			
			
		}
		return adjacentList;
	}
	public static void addEdge(List<Integer>[] adjacentList,int u,int v,boolean undirected){
		adjacentList[u].add(v);
		if(undirected)
			adjacentList[v].add(u);
		
	}
	
	public static void printRouteFromSourceToDest(int source,int destination,int[] parents,ArrayList<Integer> route){
		if(source==destination)
			return;
		int par=parents[destination];
		if(par!=source){
			printRouteFromSourceToDest(source, par, parents,route);
		
		}
		
			route.add(par);
		
	}
}
