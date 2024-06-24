//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            long n = Long.parseLong(S[0]);
            long q = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.sumMatrix(n, q));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(1)
    // SC : O(1)
    
    static long sumMatrix(long n, long q) {
        // code here
        // Base case: check if out of bound
        // Minimum: 2, Maximum: n+n  according to mat[i][j] = i+j, array is in 1-based indexing.
        if(q < 2 || q > n+n) {
            return 0;
        }
        
        if(q <= n || q == n+1) {
            return q-1;
        } 
        
        long d = q - (n+1);
        return n - d;
    }
    
}

