import java.io.IOException;


public class getIthOrderStatistics extends UtitlityReadSwapPrint{

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		int data[]=getData();
		int ithPosition=2000;
		
		System.out.println("Pos:"+ithPosition+"Element:"+ithSmallestElement(data,0, ithPosition,data.length-1));
	}
	public static int ithSmallestElement(int[] data,int start,int ithPosition,int end){
		int pivot=QuickSort.getPivotPosition(data, start,end);
		if(pivot==ithPosition)
			return data[ithPosition];
		else if(pivot<ithPosition)
			return ithSmallestElement(data, pivot+1, ithPosition, end);
		else
			return ithSmallestElement(data, start, ithPosition, pivot-1);
	}
	

}
