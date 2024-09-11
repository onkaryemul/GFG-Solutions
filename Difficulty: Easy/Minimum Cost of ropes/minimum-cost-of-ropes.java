//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    // Using Min-Heap (PriorityQueue)
    
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        // code here
        long cost = 0;
        
        // Create a priority queue (min-heap) for the ropes
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        // Add all elements from the array into the priority queue
        for(long num : arr) {
            pq.add(num);
        }
        
        // Process the ropes until there is only one left
        while(pq.size() > 1) {
            // Get the two smallest elements
            long a = pq.poll();
            long b = pq.poll();
            
            // Calculate the cost of connecting these two ropes
            cost += (a+b);
            
            // Push the new rope (commbined length) back into the priority queue
            pq.add(a+b);
        }
        
        return cost;
    }
    
}

