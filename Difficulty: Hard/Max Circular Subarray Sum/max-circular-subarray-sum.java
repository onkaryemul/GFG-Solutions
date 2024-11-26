//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // TC : O(n)
    // SC : O(1)
    
    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        // Your code here
        // either max subarray sum (maxSum) or Total Array Sum - min subarray sum (minSum)
        
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        
        int currMax = 0, currMin = 0;
        
        int total = 0;
        
        for(int num : arr) {
            total += num;
            
            currMax += num;
            currMin += num;
            
            if(currMax < 0) {
                currMax = 0;
            }
            
            if(currMin > 0) {
                currMin = 0;
            }
            
            maxSum = Math.max(maxSum, currMax);
            minSum = Math.min(minSum, currMin);
        }
        
        return Math.max(maxSum, total - minSum);
    }
    
}

