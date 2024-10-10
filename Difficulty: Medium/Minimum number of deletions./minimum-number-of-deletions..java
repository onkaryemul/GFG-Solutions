//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // TC : O(n^2)
    // SC : O(n^2)
    
    // Using the concept of "LCS (Longest Common Subsequence)"
    
    /*  
        Intuition:
            
        Find the LCS(longest common subsequence) of the given string by using another string as a reversal of the existing string
        
        Ultimately, substract the length of LCS from the length of the given string, which will give the answers
        
        ==> for minimum deletions, 
           we need to have a maximum length of largest palindromic subsequence
    */
    
    // function to return the "minimum no. of characters we need to remove/delete" from the string 
    // => so that resultant string is a palindrome
    int minDeletions(String str, int n) {
        // code here
        // to find the "largest palindrome subsequence",
        // we need given string str & its reverse
        StringBuilder sb = new StringBuilder(str);
        
        String reverseStr = sb.reverse().toString();
        
        // apply LCS(Longest Common Subsequence) => to find the LPS(longest Palindromic Subsequence)
        int[][] dp = new int[n+1][n+1];
        
        for(int i=0; i <= n; i++) {
            for(int j=0; j <= n; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (str.charAt(i-1) == reverseStr.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        // dp[n][n] => length of longest palindromic subsequence
        
        // minimum no. of deletions = n - dp[n][n]
        return n - dp[n][n];
    }
    
} 


/*
    // Approach 1:
    // Using Recursion + Memoization
    
    // Dynamic Programming
    
    // TC : O(n^2)
    // SC : O(n^2) + Recursive stack space
    
    int minDeletions(String str, int n) {
        // code here
        int[][] dp = new int[n+1][n+1];
        
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return solve(0, n-1, str, dp);
    }


    private int solve(int i, int j, String str, int[][] dp) {
        // Base case
        if(i >= j) {
            return 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        // Check if str.charAt(i) == str.charAt(j)
        if(str.charAt(i) == str.charAt(j)) {
            return dp[i][j] = 0 + solve(i+1, j-1, str, dp);
        }
        else {
            return dp[i][j] = 1 + Math.min(solve(i+1, j, str, dp), solve(i, j-1, str, dp));
        }
    }
*/

