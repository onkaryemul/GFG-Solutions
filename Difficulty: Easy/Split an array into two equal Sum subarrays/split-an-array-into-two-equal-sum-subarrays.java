//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Simple approach
    // Splitting an array into two equal sum subarrays --> means 2*subarraySum == arrSum
    public boolean canSplit(int arr[]) {
        // code here
        int n = arr.length;
        
        int arrSum = 0, subArrSum = 0;
        
        // Calculate the sum of all elements of arr
        for(int i=0; i < n; i++) {
            arrSum += arr[i];
        }
        
        // Calculate the subArrSum till 2*subArrSum == arrSum
        for(int i=0; i < n; i++) {
            subArrSum += arr[i];
            // Check if 2 * current subarray sum(subArrSum) == arrSum
            if(subArrSum * 2 == arrSum) {
                return true; // indicating that we can split arr[] into two equal subarrays
            }
        }
        
        return false; // it is impossible to split 
    }
    
}

