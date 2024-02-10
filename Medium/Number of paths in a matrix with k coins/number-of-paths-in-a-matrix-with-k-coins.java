//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            int  k = Integer.parseInt(read.readLine());
            int  n = Integer.parseInt(read.readLine());
            int arr[][] = new int[n][n];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(n, k, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// O(2^(m+n))
class Solution {
    
    long ans;
    
    
    long numberOfPath(int n, int k, int [][]arr) {
        // code here
        ans=0;
        
        dfs(0,0,arr,k);
        
        return ans;
    }
    
    
    private void dfs(int i, int j, int arr[][], int k)
    {
        int m = arr.length,  n = arr[0].length;
        
        if(k<0) return;
        
        if(i>=0 && i<m && j>=0 && j<n){
        
            if(i==m-1 && j==n-1 && k==arr[i][j])
               ans++;
        
            dfs(i+1, j,  arr, k-arr[i][j]);
            dfs(i,j+1, arr,  k-arr[i][j]);
        }
    }
}


