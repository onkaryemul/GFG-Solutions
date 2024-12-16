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
            int ans = sln.smallestDivisor(a, k);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(Log(max(arr[])) * N)
    // SC : O(1)
    
    // Binary search on our answers ==> in the range of [1, max(arr[])]. 
    
    int smallestDivisor(int[] arr, int k) {
        // code here
        int n = arr.length;
        
        if(n > k) {
            return -1; // impossible case
        }
        
        // nums.length() <= k
        
        // Find the maximum element
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        
        // apply binary search on our answers => on the range [1, maxi]
        int low = 1, high = maxi;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(sumByD(arr, n, mid) <= k) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    
    // Helper function => to calculate the sum of the division result
    // find the summation of division values
    private int sumByD(int[] arr, int n, int div) {
        int sum = 0;
        
        for(int i=0; i < n; i++) {
            sum += Math.ceil((double) arr[i] / (double) div);
        }
        
        return sum;
    }
    
}

