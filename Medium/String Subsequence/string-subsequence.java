//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s1;
            s1 = br.readLine();

            String s2;
            s2 = br.readLine();

            Solution obj = new Solution();
            int res = obj.countWays(s1, s2);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    private static final int MOD = 1000000007;
    
    // Counting the number of subsequences of string s1 equal to string s2
    public static int countWays(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        
        if(m > n) {
            return 0;
        }
        
        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return solve(n-1, m-1, s1, s2, dp);
    }
    
    // Memoization Approach
    private static int solve(int i, int j, String s1, String s2, int[][] dp) {
        // Base cases
        if(j < 0) {
            return 1;
        }
        
        if(i < 0) {
            return 0;
        }
        
        // Memoize the previously calculated result
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)) {
            // take + not take
            return dp[i][j] = (solve(i-1, j-1, s1, s2, dp)%MOD + solve(i-1, j, s1, s2, dp)%MOD)%MOD;
        }
        else {
            // not take
            return dp[i][j] = solve(i-1, j, s1, s2, dp)%MOD;
        }
    }
    
}


