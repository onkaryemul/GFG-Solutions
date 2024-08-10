//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // N = max(stalls) - min(stalls)
    // TC : O(n*logn + log(N) * O(n))
    
    
    // Binary Search
    // Function to get Minimum distance between any two cows as maximum as possible 
    public static int solve(int n, int k, int[] stalls) {
        // 1. Sort the stalls array
        Arrays.sort(stalls); 
        
        int low = 1; // minimum distance possible between cows
        int high = stalls[n-1] - stalls[0]; // maximum distance possible between cows
        
        // Apply binary search
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(canWePlace(stalls, mid, k)) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        
        return high; // max(min possible distance)
    }
    
    
    // Helper function - To check if we can place given no. of cows with minimum allowed distance (dist)
    private static boolean canWePlace(int[] stalls, int dist, int cows) {
        int n = stalls.length; // size of array
        
        int lastCowPosition = stalls[0]; // position of first cow which is usually placed at first position in an array
        // initially, we placed 1st cow at first position
         int cntCows = 1; // no. of cows placed
        
        for(int i=1; i < n; i++) {
            if(stalls[i] - lastCowPosition >= dist) {
                cntCows++; // place next cow at this position i.e. stalls[i] 
                lastCowPosition = stalls[i]; // update the last cow location
            }    
            
            if(cntCows >= cows) {
                return true;
            }
        }
        
        return false;
    }    
    
}

