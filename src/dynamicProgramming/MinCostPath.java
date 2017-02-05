package dynamicProgramming;

import java.util.Arrays;

public class MinCostPath {
static int dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cost[][] = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
		int len=3;
		dp=new int[len+1][len+1];
		for(int i=0;i<len;++i)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
	
	System.out.println(getMinCost(cost, 2, 2, len));
	printPath(cost, 2, 2);
	}
	public static void printPath(int[][] dp,int n,int m){
		
	//here first if both the values are more than 0 that means you took path earlier from either top,left or diagonal
		
		if((n>0&&m>0)){
		if(dp[n-1][m]<dp[n][m-1]&&dp[n-1][m]<dp[n-1][m-1])
			printPath(dp, n-1, m);
		else if(dp[n][m-1]<dp[n-1][m-1])
			printPath(dp, n, m-1);
		else
			printPath(dp, n-1, m-1);
		}else if(n>0){ //else if only x axis is positive you can taker path only from the left
			printPath(dp, n-1, m);
		}else if(m>0){ //else you can take the path only from top
			printPath(dp, n, m-1);
		}
		System.out.println(n+":"+m);
	}
public static int getMinCost(int[][] cost,int n,int m,int len){
	if(n<0||m<0)
		return Integer.MAX_VALUE; 
	if(dp[n][m]!=Integer.MAX_VALUE)
		return dp[n][m];
	
	if(n==0&&m==0)
		return dp[n][m]=cost[n][m];
	return dp[n][m]=cost[n][m]+Math.min(getMinCost(cost, n, m-1, len), Math.min(getMinCost(cost, n-1, m, len), getMinCost(cost, n-1, m-1, len)));
}
	
}
