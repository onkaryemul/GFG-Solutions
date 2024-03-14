//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            char A[][] = new char[N][N];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) A[i][j] = S[j].charAt(0);
            }
            Solution ob = new Solution();
            System.out.println(ob.largestSubsquare(N, A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    int largestSubsquare(int n, char a[][]) {
        // code here
        int[][] psR = new int[n][n];
        int[][] psC = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // rows
                psR[i][j] = (a[i][j] == 'X' ? (j == 0 ? 1 : psR[i][j-1] + 1) : 0);
                
                // cols
                psC[j][i] = (a[j][i] == 'X' ? (j == 0 ? 1 : psC[j-1][i] + 1) : 0);
            }
        }
        
        int max = 0;
        
        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                int size = Math.min(psR[i][j], psC[i][j]);
                
                while(size > max) {
                    if(psR[i-size+1][j] >= size && psC[i][j-size+1] >= size) {
                        max = size; // max size possible
                        break;
                    }
                    // else check for smaller size of poss
                    size--;
                }
            }
        }
        
        return max;
    }
    
};

