//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(N) => N = size of the array => for traversing on the input array
    // SC : O(N), using HashMap to store prefixSum & its frequency
    
    // Similar to "Count subarrays with sum K"   =>  Prefix Sum approach
    
    // Using HashMap to store prefixSum & its frequencies
    
    // prefixSum at particular index i => s
    // then we need to find subarray with sum K ending at index i 
    // hence remaining sum (s-K) that is to be removed
    // Therefore, in order to find the subarray with sum K ending at index i => we need to find no. of subarrays with sum (s-K) previously encountered 
    
    // Count of Subarrays with sum K ===>  Count of subarrays with sum (s-K)
    
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
        // add your code here
        int cnt = 0;
        
        int n = arr.length; // size of the given array
        
        // HashMap to store PrefixSum & its frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Setting prefix sum 0 in the map with frequency 1
        
        int prefixSum = 0;
        
        for(int i=0; i < n; i++) {
            prefixSum += arr[i]; // add the current element to the prefix sum
            
            int remove = prefixSum - tar; // calculate the x - k
            
            // Add the no. of subarrays to be removed (ie. subarrays with sum (prefixSum - K))
            cnt += map.getOrDefault(remove, 0);
            
            // Update the count of current prefix sum in the map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        return cnt;
    }
    
}


/*
Time Complexity: O(N3), where N = size of the array.
    Reason: We are using three nested loops here. Though all are not running for exactly N times, the time complexity will be approximately O(N3).
Space Complexity: O(1) as we are not using any extra space.


    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        int cnt = 0; // Number of subarrays:

        for (int i = 0 ; i < n; i++) { // starting index i
            for (int j = i; j < n; j++) { // ending index j

                // calculate the sum of subarray [i...j]
                int sum = 0;
                for (int K = i; K <= j; K++)
                    sum += arr[K];

                // Increase the count if sum == k:
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }

 
Time Complexity: O(N2), where N = size of the array.
    Reason: We are using two nested loops here. As each of them is running for exactly N times, the time complexity will be approximately O(N2).
Space Complexity: O(1) as we are not using any extra space.

    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        int cnt = 0; // Number of subarrays:

        for (int i = 0 ; i < n; i++) { // starting index i
            int sum = 0;
            for (int j = i; j < n; j++) { // ending index j
                // calculate the sum of subarray [i...j]
                // sum of [i..j-1] + arr[j]
                sum += arr[j];

                // Increase the count if sum == k:
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }
*/



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int tar = Integer.parseInt(br.readLine());
            Solution obj = new Solution();
            int res = obj.subArraySum(arr, tar);

            System.out.println(res);
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends