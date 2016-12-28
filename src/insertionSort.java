import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;


public class insertionSort extends UtitlityReadSwapPrint{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

int[] data=getData();
insertionSort(data);



print(data);

}
public static void insertionSort(int data[]){
	int i=1;
	while(i<data.length){
		int key=data[i];
		int n=i-1;
		while(n>=0&&data[n]>key){
			
			data[n+1]=data[n];
			
			n--;
		}
		data[n+1]=key;
		
		i++;
	}
	
}
	
}
