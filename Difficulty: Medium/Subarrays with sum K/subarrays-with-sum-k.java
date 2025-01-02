//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
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
            int res = new Solution().countSubarrays(arr, k);

            System.out.print(res);
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n), due to hashmap
    
    // Optimal approach => O(n) => single pass solution
    
    // Using Prefix sum approach
    
    // Using Reverse Engineering technique
    // No. of subarrays ending at index i with sum as k 
    // = prefix sum till index i (prefixSum) - no. of subarrays with sum =(prefixSum - k) in that range
    
    public int countSubarrays(int arr[], int k) {
        // code here
        int n = arr.length;
        
        // key : prefix sum till that index i
        // value : count of subarrays with that prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixSum = 0;
        int cnt = 0; // count of subarrays with sum exactly equal to k
        
        // prefixSum = 0, with count = 1
        map.put(0, 1);
        
        for(int i=0; i < n; i++) {
            prefixSum += arr[i];
            
            int remove = prefixSum - k;
            
            if(map.containsKey(remove)) {
                cnt += map.get(remove);
            }
            
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        return cnt;
    }
    
}

