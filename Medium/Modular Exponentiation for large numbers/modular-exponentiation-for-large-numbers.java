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
            String s = br.readLine();
            String[] S = s.split(" ");
            long x = Long.parseLong(S[0]);
            long n = Long.parseLong(S[1]);
            long m = Long.parseLong(S[2]);
            Solution ob = new Solution();
            long ans = ob.PowMod(x, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution
{
    public long PowMod(long x, long n, long m)
    {
        // code here
        // Base cases
        if (n == 0) {
            return 1;
        }
        
        if (n == 1) {
            return x % m;
        }

        // Recursive call
        long val = PowMod(x, n / 2, m);
        
        val = (val * val) % m;

        // If n is odd
        if (n % 2 == 1) {
            return (val * x) % m;
        }

        return val;
    }
    
}

