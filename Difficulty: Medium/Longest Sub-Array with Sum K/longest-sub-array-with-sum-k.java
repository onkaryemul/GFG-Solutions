//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();
            int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(N)
    // SC : O(N)
    
    // Prefix sum approach
    // Using HashMap to store prefix sum & index at which they occur
    
    // function to return the length of longest subarray whose sum of elements is equal to K
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Complete the function
        int maxLength = 0; // to store the maximum length of subarray with sum equal to K
        
        // HashMap to store (prefix_sum, first_occurrence_index)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int currSum = 0; // store the running prefix sum
        
        // Iterate over the array
        for(int i=0; i < N; i++) {
            currSum += A[i]; // add the current element(A[i]) to the running sum
            
            // Case 1: Check if the sum from the start(0) to the current index(i) equals K
            if(currSum == K) {
                maxLength = i + 1; // the whole array up to i ==> is the subarray
            }
            
            // Case 2: Check if (currSum - K) exists in the map
            if(map.containsKey(currSum - K)) {
                // Calculate the length of the subarray
                int len = i - map.get(currSum - K);
                maxLength = Math.max(maxLength, len);
            }
            
            // Case 3: Store the currSum in the map if it has not been stored already
            if(!map.containsKey(currSum)) {
                map.put(currSum, i);
            }
        }
        
        return maxLength; // return the maximum length of the subarray with sum equal to K
    }
    
}



