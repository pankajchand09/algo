package dynamicProgramming;

public class KnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] v = {100, 60, 120};
		int[] w = {10, 20, 30};
		int W = 55;
		int[][] Knapsack = new int[v.length + 1][W + 1];

		for (int i = 0; i <=v.length; ++i) {
			for (int j = 0; j <= W; ++j) {
				if (i == 0 || j == 0) {
					Knapsack[i][j] = 0;
				} else {
					if (j<w[i-1] ) {
						Knapsack[i][j]=Knapsack[i-1][j];

					}else{
						Knapsack[i][j]=Math.max(Knapsack[i-1][j],Knapsack[i-1][j-w[i-1]]+v[i-1]);
					}
				}
			}
		}
		System.out.println(Knapsack[v.length][W]);
System.out.println("Items added for optimal solution");
		for(int j=W,i=v.length;j>=1&&i>=1;){
			if(j<w[i-1])
			{j--;
			
			
			}else{
				if(Knapsack[i-1][j]==Knapsack[i][j]){
					j--;
					
				}else{
					System.out.println(i+"th");
					j=j-w[i-1];
					
				}
			}
			i--;
		}
	}
		
	

}
