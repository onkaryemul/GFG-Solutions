//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Prefix sum approach
    // Using HashMap to store prefix sum & index at which they occur
    
    // function to find and return the length of longest subarray whose sum of elements ie equal to K
    public int longestSubarray(int[] arr, int k) {
        // code here
        int n = arr.length;
        
        int maxLen = 0; // to store the maximum length of subarray with sum equal to K
        
        // HashMap to store (prefix_sum, first_occurrence_index)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int currSum = 0; // to store the running prefix sum
        
        // Iterate over the array
        for(int i=0; i < n; i++) {
            currSum += arr[i]; // add the current element i.e. arr[i] to the running sum
            
            // Case 1 : Check if the sm from the start (0) to the current index(i) equals K
            if(currSum == k) {
                maxLen = i + 1; // the whole subarray upto i 
            }
            
            // Case 2 : Check if (currSum - k) exists in the map ==> using Reverse engineering approach
            if(map.containsKey(currSum - k)) {
                // Calculate the length of the subarray
                int len = i - map.get(currSum - k);
                maxLen = Math.max(maxLen, len);
            }
            
            // Case 3 : Store the currSum in the map => if it has not been stored already
            if(!map.containsKey(currSum)) {
                map.put(currSum, i);
            }
        }
        
        return maxLen; // return the maximum length of the subarray with sum equal to k
    }
    
}


