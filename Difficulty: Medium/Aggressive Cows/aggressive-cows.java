//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n*logn) + O(log(max(stalls) - min(stalls)) * n)
    // SC : O(1)
    
    // Using Binary search on our answers => on the range [1, (max(stalls) - min(stalls))]
    
    // function to get minimum distance between any two cows as maximum as possible
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        
        // 1. Sort the stalls[] array
        Arrays.sort(stalls);
        
        // apply binary search on the range [1, max(stalls) - min(stalls)]
        int low = 1; // minimum distance possible between cows
        int high = stalls[n-1] - stalls[0]; // maximum distance possible between cows
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(canWePlace(stalls, n, mid, k)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return high; // max(min possible distance)
    }
    
    
    // Helper function ==> to check if we can place the given number of cows with minimum allowed distance(dist) ie. mid
    private static boolean canWePlace(int[] stalls, int n, int dist, int cows) {
        int lastCowPosition = stalls[0]; // position of first cow which is usually placed at first position in an array
        
        // Initially, we placed 1st cow at first position
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

