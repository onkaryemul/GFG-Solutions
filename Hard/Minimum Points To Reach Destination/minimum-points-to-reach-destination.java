//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int points[][] = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) points[i][j] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minPoints(points, m, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    // Tabulation Approach
    
    // TC : O(m*n)
    // SC : O(m*n)
    public int minPoints(int points[][], int m, int n) {
        // Your code goes here
        int[][] ans = new int[m][n];
        
        ans[m-1][n-1] = points[m-1][n-1] > 0 ? 1 : Math.abs(points[m-1][n-1]) + 1;
        
        for(int i = m-2; i >= 0; i--) {
            ans[i][n-1] = Math.max(ans[i+1][n-1] - points[i][n-1], 1);
        }
        
        for(int j = n-2; j >= 0; j--) {
            ans[m-1][j] = Math.max(ans[m-1][j+1] - points[m-1][j], 1);
        }
        
        for(int i = m-2; i >= 0; i--) {
            for(int j = n-2; j >= 0; j--) {
                ans[i][j] = Math.max(Math.min(ans[i+1][j], ans[i][j+1]) - points[i][j], 1);
            }
        }
        
        return ans[0][0];
    }
    
}

