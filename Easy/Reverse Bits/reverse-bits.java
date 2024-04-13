//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static Long reversedBits(Long x) {
        // code here
        StringBuilder sb = new StringBuilder(); // stores binary representation of given number x
        
        for(int i=0; i < 32; i++) {
            if((x & (1L << i)) != 0) {
                sb.insert(0, '1');
            }
            else {
                sb.insert(0, '0');
            }
        }
        
        long ans = 0; // stores the decimal value of reverse of sb
        
        for(int i=0; i < 32; i++) {
            if(sb.charAt(i) == '1') {
                ans += (1L << i);
            }
        }
        
        return ans;
    }
    
};



