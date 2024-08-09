//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            // int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().Maximize(arr));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    // TC : O(n*logn)
    // SC : O(1)
    
    // Greedy approach - Max Index should be multiplied with maximum element in the array
    int Maximize(int arr[]) {
        // Complete the function
        Arrays.sort(arr);
        
        int mod = (int)1e9 + 7;
        
        long value = 0; // use long to avoid overflow
        int n = arr.length;
        
        for(int i=0; i < n; i++) {
            value = (value + (long)i * arr[i])%mod; // take modulo at every step
        }
        
        return (int)value; // cast the result back to int
    }
    
}

