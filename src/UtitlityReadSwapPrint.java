import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public abstract class UtitlityReadSwapPrint {
	static long startTime,endTime;
	
	public static int[] getData() throws NumberFormatException, IOException{
		BufferedReader read=new BufferedReader(new FileReader(new File("data.txt")));
		int data[]=new int[10000],i=0;
		String st;
		while((st=read.readLine()) != null){
			data[i++]=Integer.parseInt(st);
		}
		startTime=System.currentTimeMillis();
		return data;
		
	}
	public static void swap(int[] data,int first,int second){
		int tmp=data[first];
		data[first]=data[second];
		data[second]=tmp;
	}
public static void print(int[] data){
	endTime=System.currentTimeMillis();
	for(int t:data)
		System.out.println(t);
	System.out.println("total elements:"+data.length+"\n total time:"+(endTime-startTime));
}
}
