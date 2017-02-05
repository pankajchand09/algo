package dynamicProgramming;

import java.util.Arrays;

public class EditDistance {
static int dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1="sundaysaturdaysaturdaysaturdaysaturdaysaturdaysaturdaysundaysundaysundaysundaysundaysundaysunday";
		String str2="saturdaysaturdaysaturdaysaturdaysaturdaysaturday";
		dp=new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<=str1.length();++i)
			Arrays.fill(dp[i], -1);
		System.out.println(getMinimumChanges(str1, str2, 0, 0));
	}
public static int getMinimumChanges(String str1,String str2,int n,int m){
	if(dp[n][m]!=-1)
		return dp[n][m];
	if(n==str1.length())
		return dp[n][m]=(str2.length()-m);
	if(m==str2.length())
		return dp[n][m]=(str1.length()-n);
	if(str1.charAt(n)==str2.charAt(m))
		return dp[n][m]=getMinimumChanges(str1, str2, n+1, m+1);
	return dp[n][m]=(1+Math.min(Math.min(getMinimumChanges(str1, str2, n, m+1), getMinimumChanges(str1, str2, n+1, m)), getMinimumChanges(str1, str2, n+1, m+1)));
}
}
