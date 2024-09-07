//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(logn) -> log(n) to the base 9
    // SC : O(1)
    
    // Using "Nonary System" (base 9 system)
    long findNth(long n) {
        // code here
        long ans = 0; // Nth natural number after removing all the numbers containing the digit 9
        long val = 1; // to multiply it with 10 (like base)
        
        while(n > 0) {
            ans += (val * (n%9));
            n /= 9;
            val *= 10;
        }
        
        return ans;
    }
    
}

