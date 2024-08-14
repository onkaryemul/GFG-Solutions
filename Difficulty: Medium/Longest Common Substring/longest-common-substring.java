//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // Similar to "Longest Common Subsequence(LIS)"
    
    // TC : O(n*m)
    // SC : O(n*m)
    
    // DP on Strings
    // Function to find the "length" of the Longest Common Substring (LCS)
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int n = str1.length();
        int m = str2.length();
        
        int ans = 0; // to store the maximum LCS(Longest Common Substring) length
        
        // Create a 2D array to store LCS lengths
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1; i <= n; i++) {
            for(int j=1; j <= m; j++) {
                // If the characters at the current indices are the same, extend the LCS
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]); // Update the maximum LCS length
                }
                else {
                    dp[i][j] = 0; // Reset the LCS length if characters don't match
                }
            }
        }
        
        return ans; // return the length of the longest common substring (LCS)
    }
    
}

