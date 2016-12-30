package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MaxWeightIndependentSet {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
String[] split=reader.readLine().split(" ");
int[] weight=new int[split.length+1],maxweight=new int[split.length+1];
for(int i=0;i<split.length;++i)
	weight[i+1]=Integer.parseInt(split[i]);
weight[0]=0;

maxweight[0]=0;
maxweight[1]=weight[1];
for(int i=2;i<weight.length;++i){
	maxweight[i]=Math.max(maxweight[i-1], maxweight[i-2]+weight[i]);
}
System.out.println(maxweight[weight.length-1]);
 int i=0;
for( i=weight.length-1;i>1;)
{
	if(maxweight[i-1]>=maxweight[i-2]+weight[i])
		{--i;
		continue;
		}
	else{
		System.out.print((i)+"\t");
	i=i-2;	
	}
	}
if(i==1)
System.out.println(i);

	}

}
