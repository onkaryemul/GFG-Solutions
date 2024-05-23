//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n*n)
    // SC : O(n*n)
    
    // Longest Palindrome Sequence (LPS) Approach
    public int kPalindrome(String str, int n, int k) {
        // code here
        StringBuilder sb = new StringBuilder(str);
        
        String s1 = str;
        String s2 = sb.reverse().toString();
        
        int[][] dp = new int[n+1][n+1];
        
        for(int i=0; i <= n; i++) {
            for(int j=0; j <= n; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return (n - dp[n][n] <= k) ? 1 : 0;
    }
    
}


