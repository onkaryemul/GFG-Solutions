//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    // TC : O(2*nlogn + 2*n) ~ O(n*logn)
    // SC : O(1)
    
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        // 1. Sort the arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int result = 1; // tracks minimum no. of platforms required at the railway station such that no train waits
        int platformsNeeded = 1;
        
        int i = 1; // considering 0th train already, hence looking from 1st train
        int j = 0;
        
        while(i < n && j < n) {
            if(arr[i] <= dep[j]) {
                platformsNeeded++;
                i++;
            }
            else if (arr[i] > dep[j]) {
                platformsNeeded--;
                j++;
            }
            
            if(platformsNeeded > result) {
                result = platformsNeeded;
            }
        }
        
        return result;
    }
    
}

