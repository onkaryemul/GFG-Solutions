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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalCount(String str)
    {
        // Code here
        int n = str.length();
        int[] suffix = new int[n+1];
        int MAX = 0;
        
        for(int i = n - 1; i >= 0 ; i--) {
            suffix[i] = suffix[i+1] + (str.charAt(i) - '0');
            MAX += (str.charAt(i) - '0');
        }
     
        int[][] dp = new int[n + 1][MAX + 1];  
        
        
        for(int i=0; i<n; i++) {
            for(int j = suffix[0] - suffix[i+1]; j < MAX + 1; j++) {
                dp[i][j] = 1;
            }
        }
        
        
        for(int end=0; end < n; end++) {
            for(int sum = 0; sum < MAX+1; sum++) {
                int low = -1;
                int high = end + 1;
                
                while(low < high - 1) {
                    int mid = low + (high - low)/2;
                    
                    int curr_sum = suffix[mid] - suffix[end + 1];
                    
                    if(curr_sum <= sum) {
                        high = mid;
                    } 
                    else {
                        low = mid;
                    }
                }
                
                
                for(int br=high; br < end+1; br++) {
                    int curr_sum = suffix[br] - suffix[end + 1];
                    
                    if(curr_sum <= sum) {
                        dp[end][sum] += (br > 0 ? dp[br-1][curr_sum] : 0);
                    }
                }
            }
        }
        
        return dp[n-1][MAX];
    }
    
}





