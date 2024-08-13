//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int a = sc.nextInt();
            long b = sc.nextLong();

            Solution ob = new Solution();
            System.out.println(ob.power(a, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {

    // Power Exponentiation (Binary Exponentiation)
    
    // TC : O(logb) (if x^n, then its TC would be logn)
    // SC : O(1)

    static long power(int a, long b) {
        //complete the function here
        int mod = 1000000007;
        
        long res = 1;
        long base = a;
        
        while(b > 0) {
            // Check if b is odd
            if(b%2 != 0) {
                res = (res * base)%mod;
            }
            base = (base*base)%mod; // square the base
            b = b/2; // redure the power by half
        }
        
        return res;
    }
    
}


