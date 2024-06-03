//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    private static long MOD = 1000000007;
    
    // TC : O(n)
    // SC : O(2n)
    static int numberOfConsecutiveOnes(int n) {
        // code here
        long[] a = new long[n];
        long[] b = new long[n];
        
        a[0] = 1;
        b[0] = 1;
        
        for(int i=1; i < n; i++) {
            a[i] = (a[i-1] + b[i-1])%MOD;
            b[i] = a[i-1];
        }
        
        return (int)((power(2, n) + MOD - (a[n-1] + b[n-1])%MOD)%MOD);
    }
    
    
    private static long power(long a, long b) {
        long ans = 1;
        
        while(b > 0) {
            if((b&1) == 1) {
                ans = (ans*a)%MOD;
            }
            a = (a*a)%MOD;
            b >>= 1;
        }
        
        return ans;
    }
    
}

