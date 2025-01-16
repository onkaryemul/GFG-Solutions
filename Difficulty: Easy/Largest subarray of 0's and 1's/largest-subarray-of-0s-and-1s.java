//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n) => 1 pass solution
    // SC : O(n) => due to HashMap 
    
    // Using Prefix sum approach 
    // Using the concept of "Longest subarray with sum K" => reverse engineering approach
    
    // Since, here arr[] contains only 0's and 1's
    // So longest subarray with equal no. of 0's and 1's => will have sum as 0 (after modification of arr[] such that arr[i] = -1, for every arr[i]=0)
    
    // function to find the length of longest subarray with equal no. of 0's and 1's
    public int maxLen(int[] arr) {
        // Your code here
        int n = arr.length;
        
        int maxLen = 0; // length of the longest subarray with equal no. of 0's and 1's
        
        // For subarray with equal no. of 0's and 1's :
        // we are adding -1 to the prefix sum wherever arr[i] = 0, and 1 for arr[i] = 1
        // So that, that subarray with equal no. of 0's and 1's => will have sum = 0
        
        
        // Therefore, this question is similar to "longest subarray with sum k"
        // Here, we need to find "Longest subarray with sum 0", here k = 0
        
        int k = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        // key : prefix_sum
        // value : index at which this prefix_sum occurred for the first time (leftmost) => in order to get longest subarrayy
        
        map.put(0, -1); // 0 sum at index -1
        
        int sum = 0; // running sum or prefix sum
        
        for(int i=0; i < n; i++) {
            if(arr[i] == 0) {
                sum += (-1);
            }
            else {
                sum += 1;
            }
            
            if(sum == k) {
                maxLen = i + 1;
            }
            
            // Check if remaining ie. (sum - k) previously appeared
            if(map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }
            
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        
        return maxLen;
    }
    
}

