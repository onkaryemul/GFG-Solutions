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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            long ans = ob.min_operations(nums);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // TC : O(n^2)
    // SC : O(n)
    public int min_operations(int []nums)
    {
        // Code here
        int n = nums.length;
        
        int l = LIS(nums, n);
        
        return n - l;
    }
    
    
    // Longest Increasing Subsequence(LIS) --> with slight modification
    private int LIS(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int maxi = 1; // since every single element can be considered as increasing
        
        for(int i=1; i < n; i++) {
            for(int j=0; j < i; j++) {
                // arr[i] - arr[j] >= i-j  ---> slight modification
                if(arr[i] > arr[j] && arr[i] - arr[j] >= i-j) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        
        return maxi;
    }
    
}



