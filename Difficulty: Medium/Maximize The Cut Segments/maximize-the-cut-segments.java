//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Dynamic Programming : Recursion + Memoization
    
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z) {
       //Your code here
       int[] dp = new int[n+1]; // initially, all are marked as 0
       
       int maxCuts = cutsHelper(n, x, y, z, dp);
       
       if(maxCuts <  0) { // If no segment can be cut, then return 0
           return 0;
       }
       
       return maxCuts;
    }
    
    
    // Helper function -> to calculate the maximum no. of cut segments possible
    private int cutsHelper(int n, int x, int y, int z, int[] dp) {
        // Edge case
        if(n < 0) {
            return Integer.MIN_VALUE; // denoting that cut is not possible
        }
        
        // Base case 
        if(n == 0) {
            return 0; // denoting successful cut
        }
        
        // Check if dp[n] is already computed
        if(dp[n] != 0) {
            return dp[n];
        }
        
        // Explore all cuts through x, y, and z
        int cutX = cutsHelper(n-x, x, y, z, dp);
        int cutY = cutsHelper(n-y, x, y, z, dp);
        int cutZ = cutsHelper(n-z, x, y, z, dp);
        
        return dp[n] = 1 + Math.max(cutX, Math.max(cutY, cutZ));
    }
    
}


