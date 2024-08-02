//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n*m)
    // SC : O(n*m)
    
    public int editDistance(String str1, String str2) {
        // Code here
        int n = str1.length();
        int m = str2.length();
        
        int[][] dp = new int[n][m];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        // call the recursive helper function
        return editDistanceHelper(n-1, m-1, str1, str2, dp);
    }
    
    
    // Helper function to calculate the minimum edit distance between two strings
    private int editDistanceHelper(int i, int j, String s1, String s2, int[][] dp) {
        // Base cases
        if(i < 0) {
            return j+1;
        }
    
        if(j < 0) {
            return i+1;
        }
        
        // Check if result is already computed, if yes return it
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        // If the characters at the current positions match, no edit is needed
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = editDistanceHelper(i-1, j-1, s1, s2, dp);
        }
        
        // Minimum of three choices:
        // 1. Replce the character in s1 with character in s2
        // 2. Delete the character in s1
        // 3. Insert the character from s2 into s1
        
        return dp[i][j] = 1 + Math.min(editDistanceHelper(i-1, j-1, s1, s2, dp), 
                                       Math.min(editDistanceHelper(i-1, j, s1, s2, dp), editDistanceHelper(i, j-1, s1, s2, dp)));
    }
    
}


/*
    // Function to calculate the minimum edit distance between two strings
    static int editDistance(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        // Create a 2D array to store the minimum edit distances
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the first row and column with their respective indices
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    // If the characters match, no edit is needed, so take the value from the diagonal.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the characters don't match, take the minimum of three possibilities:
                    // 1. Replace the character in S1 with the character in S2 (diagonal).
                    // 2. Delete the character in S1 (left).
                    // 3. Insert the character from S2 into S1 (up).
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[n][m];
    }
*/

