//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n * m)
    // SC : O(n * m)
    
    // Using Dynamic Programming
    // Longest Common Subsequence (LIS) -> tabulation approach
	public int minOperations(String str1, String str2) { 
	    // Your code goes here
	    int n = str1.length();
	    int m = str2.length();
	    
	    // Apply Longest Common Subsequence (LIS) using tabulation
	    int[][] dp = new int[n+1][m+1];
	    int lcs = 0;
	    
	    for(int i=0; i <= n; i++) {
	        for(int j=0; j <= m; j++) {
	            if(i == 0 || j == 0) {
	                dp[i][j] = 0;
	                continue;
	            }
	            
	            if(str1.charAt(i-1) == str2.charAt(j-1)) {
	                dp[i][j] = 1 + dp[i-1][j-1];
	            }
	            else {
	                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	            }
	            
	            lcs = Math.max(lcs, dp[i][j]);
	        }
	    }
	    
	    return (n - lcs) + (m - lcs);
	} 
	
}


/* 
    int lcs(String str1, int n, String str2, int m, int[][] dp){
        if(n < 0 || m < 0){
            return 0;
        }
        
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        
        if(str1.charAt(n) == str2.charAt(m)){
            return dp[n][m] = 1 + lcs(str1, n - 1, str2, m - 1, dp);
        }
        
        return dp[n][m] = Math.max(lcs(str1, n - 1, str2, m, dp), lcs(str1, n, str2, m - 1, dp));
    }
    
    
	public int minOperations(String str1, String str2) { 
	    // Your code goes here
	    int n = str1.length();
	    int m = str2.length();
	    
	    int[][] dp = new int[n + 1][m  +1];
	    for(int[] row : dp){
	        Arrays.fill(row, -1);
	    }
	    
	    int lcsLen = lcs(str1, n - 1, str2, m - 1, dp);
	    
	    return str1.length() - lcsLen + str2.length() - lcsLen;
	}
*/

