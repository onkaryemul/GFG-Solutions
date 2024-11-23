//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());
            String input = br.readLine().trim();

            // Split the input line into integers and store them in the array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the getMinDiff method
            int res = ob.getMinDiff(k, arr);

            // Print the result
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n*logn)
    // SC : O(1)
    
    // Using Greedy approach
    
    public int getMinDiff(int k, int[] arr) {
        // code here
        int n = arr.length;
        
        Arrays.sort(arr); // greedy approach
        
        int ans = arr[n-1] - arr[0];
        
        int max = 0;
        int min = 0;
        
        int largest = arr[n-1] - k;
        int smallest = arr[0] + k;
        
        for(int i=0; i < n-1; i++) {
            min = Math.min(smallest, arr[i+1] - k);
            
            max = Math.max(largest, arr[i] + k);
            
            ans = Math.min(ans, max - min);
        }
        
        return ans;
    }
    
}

