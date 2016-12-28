import java.io.IOException;


public class HeapSort extends UtitlityReadSwapPrint {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		int[] data=getData();
		heapSort(data);
		print(data);

	}
	 
	public static void heapSort(int[] data){
		for(int i=data.length/2-1;i>=0;--i)
			minHeapify(data, i,data.length);
		for(int i=data.length-1;i>0;--i){
		swap(data, i, 0);
			minHeapify(data, 0, i);
		}
	}
public static void minHeapify(int[] data,int parent,int size){
	
	int leftChild=parent*2+1,rightChild=parent*2+2;
	int minElement=data[parent],pos=parent;
	if(leftChild<size&&data[pos]>data[leftChild]){
		pos=leftChild;
	}
	if(rightChild<size&&data[pos]>data[rightChild]){
		pos=rightChild;
	}
	if(pos!=parent)
	{swap(data, pos, parent);
	minHeapify(data, pos,size);
	}
}
}
