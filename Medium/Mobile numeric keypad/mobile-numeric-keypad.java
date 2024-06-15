//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n*10) ~ O(n)
    
    // Dynamic Programming Approach
    public long getCount(int n) {
        // Your code goes here
        // Base case
        if(n == 1) {
            return 10;
        }
        
        // Define the adjacency list for each digit
        int[][] adj = {
            {0, 8},        // 0
            {1, 2, 4},     // 1
            {2, 1, 3, 5},  // 2
            {3, 2, 6},     // 3
            {4, 1, 5, 7},  // 4
            {5, 2, 4, 6, 8}, // 5
            {6, 3, 5, 9},  // 6
            {7, 4, 8},     // 7
            {8, 5, 7, 9, 0}, // 8
            {9, 6, 8},     // 9
        };
        
        long[][] dp = new long[n+1][10];
        
        // Initialize base case for sequence of length 1
        for(int i=0; i < 10; i++) {
            dp[1][i] = 1;
        }
        
        // Fill DP table
        for(int len=2; len <= n; len++) {
            for(int digit=0; digit < 10; digit++) {
                dp[len][digit] = 0;
                for(int neighbor : adj[digit]) {
                    dp[len][digit] += dp[len-1][neighbor];
                }
            }
        }
        
        // Sum up all sequences of length n ending in any digit
        long total = 0;
        
        for(int digit=0; digit < 10; digit++) {
            total += dp[n][digit];
        }
        
        return total;
    }
    
}


