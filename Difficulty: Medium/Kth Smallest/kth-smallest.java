//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
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
            Solution ob = new Solution();
            out.println(ob.kthSmallest(arr, key));
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n + max_element)
    // SC : O(max_element)
    
    // Without using Heap (Priority Queue)
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        int n = arr.length;
        
        int max = arr[0];
        for(int i=1; i < n; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        
        int[] freq = new int[max + 1];
        for(int num : arr) {
            freq[num] += 1;
        }
        
        for(int i=0; i <= max; i++) {
            if(freq[i] > 0) {
                k--;
            }
            
            if(k == 0) {
                return i;
            }
        }
        
        return -1;
    }
    
}


/* 
    public static int kthSmallest(int[] arr, int k) {
        // Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : arr){
            if(pq.size()>=k && i<pq.peek())  
                pq.remove();
                
            if(pq.size()<k) 
                pq.add(i);
        }
        
        return pq.peek();
    }
*/

