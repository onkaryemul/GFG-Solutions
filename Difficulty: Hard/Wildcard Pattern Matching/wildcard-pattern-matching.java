//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n*m)
    // SC : O(n*m) + Auxilly stack space(n*m)
    
    // DP on strings - Recursion + Memoization
    
    // Main function to check if S1(pattern) matches with S2(str)
    public int wildCard(String pattern, String str) {
        // Your code goes here
        int n = str.length();
        int m = pattern.length();
        int[][] dp = new int[n + 1][m  +1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return util(str, pattern, n - 1, m - 1, dp) == true ? 1 : 0;
    }
    
    boolean util(String str, String pattern, int n, int m, int[][] dp){
        if(n < 0 && m < 0){
            return true;
        }
        
        if(m < 0){
            return false;
        }
        
        if(n < 0){
            while(m >= 0){
                if(pattern.charAt(m) != '*'){
                    return false;
                }
                --m;
            }
            return true;
        }
        
        if(dp[n][m] != -1){
            return dp[n][m] == 1 ? true : false;
        }
        
        if(str.charAt(n) == pattern.charAt(m) || pattern.charAt(m) == '?'){
            boolean res = util(str, pattern, n - 1, m - 1, dp);
            dp[n][m] = res ? 1 : 0;
            return res;
        }
        
        if(pattern.charAt(m) == '*'){
            boolean res = util(str, pattern, n - 1, m, dp) || util(str, pattern, n, m - 1, dp);
            dp[n][m] = res ? 1 : 0;
            return res;
        }
        
        return false;
    }

}

