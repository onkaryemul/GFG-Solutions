//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
        // Fibonacci series
        long mod = 1000000007;
        
        long a = 1, b = 1, c = 0;
        
        for(int i=1; i<=N; i++) {
            c = (a%mod + b%mod)%mod;
            a = b%mod;
            b = c%mod;
        }
        
        return (int)((c*c)%mod);
    }
    
}

