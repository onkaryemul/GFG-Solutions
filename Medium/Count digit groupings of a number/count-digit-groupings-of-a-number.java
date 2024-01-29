//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[][] dp;
    
    
    public int TotalCount(String str)
    {
        // Code here
        int n = str.length();
        
        dp = new int[n][9*n];
        
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        // index = 0
        // sum = 0
        return grouping(str, 0, 0);
    }
    
    
    private int grouping(String str, int index, int sum) {
        // Base case
        if(index == str.length()) {
            return 1;
        }
        
        if(dp[index][sum] != -1) {
            return dp[index][sum];
        }
        
        int ans = 0;
        
        int currentSum = 0;
        
        for(int i=index; i < str.length(); i++) {
            currentSum += (str.charAt(i) - '0');
            
            if(currentSum >= sum) {
                ans += grouping(str, i+1, currentSum);
            }
        }
        
        
        return dp[index][sum] = ans;
    }
}





