//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    static int mod = 1000000007;
    
    // Fibonacci Sequence
    static int firstElement(int n) {
        // Base case
        if(n==0 || n==1) {
            return 1;
        }
        
        int a=1, b=1;
        
        int c = 0;
        
        for(int i=2; i < n; i++) {
            c = (a + b)%mod;
            a = b%mod;
            b = c%mod;
        }
        
        // return the a10 
        return c%mod;
    }
    
}

