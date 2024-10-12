//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[s.length];
            for (int i = 0; i < s.length; i++) a[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            int res = obj.pairWithMaxSum(a);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Function to find & return the maximum sum of the smallest and second smallest element amoong all possible subarrays of size > 1
    // If it is not possible, then return -1
    public int pairWithMaxSum(int[] arr) {
        // code here
        int n = arr.length;
        
        // Edge case
        if(n == 1) {
            return -1;
        }
        
        // Maximum sum of "smallest" & "second smallest" element among all possible subarrays of size > 1
        // ==> 
        // "take window of size 2" => so that one is smallest & other is second smallest
        
        int maxPairSum = 0;
        
        for(int i=0; i < n-1; i++) {
            int currSum = arr[i] + arr[i+1];
            maxPairSum = Math.max(maxPairSum, currSum);
        }
        
        return maxPairSum;
    }
    
}

