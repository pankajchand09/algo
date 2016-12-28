package Graph.minimumSpaning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class UtilGetData {
public static GeneralGraph getData(String filename,boolean undirected) throws IOException{
	BufferedReader reader=new  BufferedReader(new FileReader(filename));
	String str=reader.readLine();
	
	GeneralGraph g=new GeneralGraph(Integer.parseInt(str));
	while((str=reader.readLine())!=null){
		String[] coordinates=str.split(" ");
		int source=Integer.parseInt(coordinates[0]);
		int des=Integer.parseInt(coordinates[1]);
		int weight=Integer.parseInt(coordinates[2]);
		g.addEdge(source-1, des-1, weight,undirected);
		
		
	}
return g;
}
}
