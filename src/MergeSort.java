import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MergeSort extends UtitlityReadSwapPrint {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] data=getData();
		
		mergeSort(data,0,data.length-1);
		
		print(data);
		
	}
public static void mergeSort(int[] data,int start,int end){
if(start<end){
	int mid=(start+end)/2;
	mergeSort(data, start,mid);
	mergeSort(data, mid+1, end);
	merge(data,start,mid,end);
}
}
public static void merge(int[] data,int start,int mid,int end){
int tmp[]=new int[end-start+1];
int i=start,j=mid+1,k=0;
while(i<=mid&&j<=end){
	if(data[i]<data[j]){
		tmp[k++]=data[i++];
	}else{
		tmp[k++]=data[j++];
	}
}
while(i<=mid){
	tmp[k++]=data[i++];
}
while(j<=end){
	tmp[k++]=data[j++];
}

for(i=start,k=0;i<=end;i++,k++){
	data[i]=tmp[k];
}
}
}
