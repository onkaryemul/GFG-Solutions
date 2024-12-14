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

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(logn)
    // SC : O(1)
    
    // Optimal Solution
    // Using Binary Search
    
    int search(int[] arr, int key) {
        // Complete this function
        int n = arr.length;
        
        int l = 0, r = n-1;
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            
            // if mid points to the target
            if(arr[mid] == key) {
                return mid;
            }
            // if left part is sorted
            else if(arr[l] <= arr[mid]) {
                if(arr[l] <= key && key <= arr[mid]) {
                    r = mid - 1; // element exits
                }
                else {
                    l = mid + 1; // element does not exist
                }
            }
            // if right part is sorted
            else {
                if(arr[mid] <= key && key <= arr[r]) {
                    l = mid + 1; // element exists
                }
                else {
                    r = mid - 1; // element does not exist
                }
            }
        }
        
        return -1;  // if not found
    }
    
}


