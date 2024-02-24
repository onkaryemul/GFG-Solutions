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
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    // Dynamic Programming
    // TC : O(n)  &  SC : O(n)
    public int maxSum(int n) 
    { 
        //code here.
        if(n == 0) {
            return 0;
        }
        
        int[] maximumSum = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            maximumSum[i] = Math.max(i, maximumSum[i/2] + maximumSum[i/3] + maximumSum[i/4]);
        }
        
        return maximumSum[n];
    } 
    
}
