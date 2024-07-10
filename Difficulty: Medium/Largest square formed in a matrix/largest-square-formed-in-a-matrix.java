//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n*m)
    // SC : O(n*m)
    
    private static int maxi;
    
    // Dynamic Programming : Memoization + Recursion
    static int maxSquare(int n, int m, int mat[][]) {
        // code here
        maxi = 0;
        
        int[][] dp = new int[n][m];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        solve(0, 0, mat, dp);
        
        return maxi;
    }
    
    
    private static int solve(int i, int j, int[][] mat, int[][] dp) {
        // Base case
        if(i >= mat.length || j >= mat[0].length) {
            return 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int right = solve(i, j+1, mat, dp);
        int diagonal = solve(i+1, j+1, mat, dp);
        int down = solve(i+1, j, mat, dp);
        
        if(mat[i][j] == 1) {
            dp[i][j] = 1 + Math.min(right, Math.min(diagonal, down));
            maxi = Math.max(maxi, dp[i][j]);
            return dp[i][j];
        }
        else {
            return dp[i][j] = 0;
        }
    } 
    
}

