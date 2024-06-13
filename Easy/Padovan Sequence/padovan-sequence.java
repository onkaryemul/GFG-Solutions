//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java
class Solution
{
    // TC : O(n)
    // SC : O(1)
    
    int mod = 1000000007;
    
    // Padovan Sequence: 1, 1, 1, 2, 2, 3, 4, 5, ....
        
    // P(n) = P(n-2) + P(n-3)
    // P(0) = P(1) = P(2) = 1

    // Space Optimised Approach
    public int padovanSequence(int n)
    {
        //code here
        
        // Base case
        if(n <= 2) {
            return 1;
        }
        
        int a = 1, b = 1, c = 1, d = 0;
        
        for(int i=3; i <= n; i++) {
            d = (a%mod + b%mod)%mod;
            a = b;
            b = c;
            c = d;
        }
        
        return d;
    }
    
}

