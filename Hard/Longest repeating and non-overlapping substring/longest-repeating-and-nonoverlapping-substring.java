//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    
    // TC : O(n^2) 
    // SC : O(n^2)
    static String longestSubstring(String s, int n) {
        // code here
        int[][] LCS = new int[n+1][n+1];
        
        int resLength = 0;
        int idx = 0;
        
        for(int i=1; i <= n; i++) {
            
            for(int j=i+1; j <= n; j++) {
                
                if(s.charAt(i-1) == s.charAt(j-1) && LCS[i-1][j-1] + 1 <= (j-i)) { // no overlapping
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                    
                    if(LCS[i][j] > resLength) { // do not update for equal, only consider for greater, 1st occurence
                        resLength = LCS[i][j];
                        idx = i-1;
                    }
                }
            }
            
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        if(resLength > 0) {
            for(int i = idx - resLength + 1; i <= idx; i++) {
                sb.append(s.charAt(i));
            }
        }
        else {
            sb.append("-1");
        }
        
        return sb.toString();
    }
    
};

