import java.io.IOException;


public class CountingSort extends UtitlityReadSwapPrint {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
int data[]=getData();
countingSort(data);
//print(data);
	}
	
	public static void countingSort(int[] data){
	int size=getMax(data);
	int[] count=new int[size+1],sorted=new int[data.length];
	for(int i=0;i<data.length;++i)
		count[data[i]]++;
	for(int i=1;i<count.length;++i)
		count[i]+=count[i-1];
	for(int i=0;i<data.length;++i)
		sorted[--count[data[i]]]=data[i];
	
	print(sorted);
	}
	public static int getMax(int data[]){
		int max=data[0];
for(int e:data)
	max=Math.max(e, max);
return max;
	}

}
