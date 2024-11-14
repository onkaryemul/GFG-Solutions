//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n*logk)
    // SC : O(k)
    
    // Using PriorityQueue => to sort the array optimally in place
    
    // Non-static method, so you need to call it on an instance of the class
    public void nearlySorted(int[] arr, int k) {
        // code
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap, by default
        
        int n = arr.length;
        
        int j = 0;
        
        // add first (k+1) elements of arr[] into the priorityqueue
        // and then take the minimum of those (k+1) elements => which are atmost k away from its target position
        
        // and then remove that element from priorityqueue & place it in j pointer index
        for(int i=0; i < n; i++) {
            pq.add(arr[i]);
            
            // If i >= k, it means we have (k+1) elements into priorityqueue, so we can take minimum element from it and remove it
            if(i >= k) {
                arr[j] = pq.remove();
                j++;
            }
        }
        
        // Remove rest of the elements from priorityqueu  & place them in j pointer index
        while(j < n) {
            arr[j] = pq.remove();
            j++;
        }
    }
    
}




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
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // Create an instance of the Solution class
            Solution obj = new Solution();
            // Call nearlySorted on the instance
            obj.nearlySorted(arr, k);

            // Print the sorted array
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends