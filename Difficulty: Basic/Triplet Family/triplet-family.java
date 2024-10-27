//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    
    // TC : O(n*logn + n^2) ~ O(n^2)
    // SC : O(1)
    
    public boolean findTriplet(int[] arr) {
        // 1. Sort the input array arr[] in ascending order
        Arrays.sort(arr);
        
        // Now, arr will have largest element on the right hand side & smallest elements on the left hand side
        int n = arr.length;
        
        // O(n^2)
        for(int i=n-1; i >= 0; i--) { 
            int target = arr[i];
            
            // Apply two-pointers approach => to find the pair of elements arr[start] + arr[end] = target = arr[i]
            int start = 0;
            int end = i-1;
            
            while(start < end) {
                if(arr[start] + arr[end] == target) {
                    return true; // found a triplet
                }
                else if(arr[start] + arr[end] < target) {
                    start++; // to increase the sum & get closer to target, we need to increase the smaller elements (ie. start)
                } 
                else { // arr[start] + arr[end] > target
                    end--; // to decrease the sum & get closer to target, we need to decrease the larger elements (ie. end) 
                }
            }
        }
        
        return false; // no triplet found
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

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            boolean res = obj.findTriplet(arr);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends