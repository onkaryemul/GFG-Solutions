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
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // Using Binary Search & "Power Exponentiation" (Binary Exponentiation)
    
    // TC : O(logm * logn)
    // SC : O(1)
    
    public int NthRoot(int n, int m) {
        // code here
        // Use binary search on the answer space
        int low = 1, high = m;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            long val = getPower(mid, n, m);
            
            if(val == m) {
                return mid;
            }
            else if(val < m) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }
        
        return -1; // if nth root of m is not a valid integer
    }
    
    
    // Function to return x to the power n (x^n) using Power Exponentiation
    private long getPower(int x, int n, int m) {
        long res = 1;
        
        for(int i=1; i <= n; i++) {
            res = res * x;
            // Early exit if res exceeds m
            if(res > m) {
                return m+1;
            }
        }
        
        return res;
    }
    
}


/* 
    //Return 1 if mid == m
    //Return 0 if mid < m
    //Return 2 if mid > m
    
    public static int func(int mid, int n, int m) {
        long ans = 1;
        
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        
        if (ans == m) return 1;
        
        return 0;
    }


    public static int NthRoot(int n, int m) {
        // Use binary search on the answer space:
        int low = 1, high = m;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            int midN = func(mid, n, m);
            
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }

*/

