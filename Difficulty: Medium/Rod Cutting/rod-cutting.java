//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n^2)
    // SC : O(n^2)
    
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return cutRodHelper(n-1, n, price, dp);
    }
    
    
    private int cutRodHelper(int idx, int len, int[] price, int[][] dp) {
        // Base case 
        if(idx == 0) {
            return len * price[0];
        }
        
        if(dp[idx][len] != -1) {
            return dp[idx][len];
        }
        
        int notTake = 0 + cutRodHelper(idx-1, len, price, dp);
        
        int take = Integer.MIN_VALUE;
        int rodLength = idx + 1;
        
        if(rodLength <= len) {
            take = price[idx] + cutRodHelper(idx, len-rodLength, price, dp);
        }
        
        return dp[idx][len] = Math.max(notTake, take);
    }
    
}


