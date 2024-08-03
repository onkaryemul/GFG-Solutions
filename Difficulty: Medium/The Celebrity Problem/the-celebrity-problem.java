//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length; // given square matrix mat
        
        int top = 0, down = n-1;
        
        while(top < down) {
            // if top knows down, then top cannot be a celebrity
            if(mat[top][down] == 1) { 
                top++;
            }
            // if down knows top, then down cannot be a celebrity
            else if(mat[down][top] == 1) {
                down--;
            }
            // if both top & down don't know each other, then both are not a celebrity
            else {
                top++;
                down--;
            }
        }
        
        // Edge case
        if(top > down) {
            return -1; // celebrity does not exist, return -1
        }
        
        // top == down
        // Validate celebrity at index top
        for(int i=0; i < n; i++) {
            if(i != top) {
                // celebrity top don't know any other, but all other knows celebrity top
                if(mat[top][i] == 0 && mat[i][top] == 1) {
                    continue;
                }
                else {
                    return -1;
                }
            }
        }
        
        return top;
    }
    
}

