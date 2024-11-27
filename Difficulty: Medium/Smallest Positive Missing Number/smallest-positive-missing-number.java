//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using Optimised approach
    // Using cyclic sort
    
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // code here
        int n = arr.length;
        
        for(int i=0; i<n; i++) {
            if(arr[i] <= 0) {
               arr[i] = (int)1e9;
            } 
        }
        
        for(int i=0; i<n; i++) {
            int cur = Math.abs(arr[i]);
            
            if(cur > 0 && cur <= n){
                int id = cur-1;
                arr[id] = - Math.abs(arr[id]);
            }
        }
        
        for(int i=0; i<n; i++){
            if(arr[i] > 0) {
                return i+1;
            }  
        }
        
        return n+1;
    }
    
}

