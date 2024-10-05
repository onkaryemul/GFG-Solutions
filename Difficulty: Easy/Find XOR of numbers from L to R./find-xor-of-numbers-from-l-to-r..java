//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int l;
            l = sc.nextInt();

            int r;
            r = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.findXOR(l, r);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(1)
    // SC : O(1)
    
    // Properties of XOR:
    // 1. x ^ x = 0
    // 2. 0 ^ x = x
    
    
    // (1 ^ 2 ^ 3 ...... ^ l-1) ^ (1 ^ 2 ^ 3 ^ ............. ^ l-1 ^ l ^ )
    
    // function to return the XOR of elements of the range [L, R]
    public static int findXOR(int l, int r) {
        return getXOR(l-1) ^ getXOR(r);
    }
    
    
    // helper function 
    // get XOR of all elements from 1 to n ==> using observation
    private static int getXOR(int n) {
        if(n%4 == 1) {
            return 1;
        }
        
        if(n%4 == 2) {
            return n + 1;
        }
        
        if(n%4 == 3) {
            return 0;
        }
        
        // else n%4 == 0
        return n;
    }
    
}

