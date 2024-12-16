//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s[] = sc.nextLine().split(" ");
            int n = s.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);
            int m = Integer.parseInt(sc.nextLine());
            int k = Integer.parseInt(sc.nextLine());
            Solution obj = new Solution();
            int res = obj.solve(m, k, arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(log(max(arr[]) - min(arr[]) + 1) * N)
    // SC : O(1)
    
    // Binary search on our answers ==> in the range of [min(arr[]), max(arr[])] 
    
    public static int solve(int m, int k, int[] arr) {
        int n = arr.length;
        
        long val = (long) m * k;
        
        if(val > n) {
            return -1; // impossible case
        }
        
        // Find minimum and maximum of arr[] => to get range of our answers
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        
        for(int i=0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        
        // apply binary search on range [mini, maxi]
        int low = mini;
        int high = maxi;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(isPossible(arr, n, mid, m, k)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    
    // Helper function => to check if it is possible to make m bouquets within 'mid' number of days 
    private static boolean isPossible(int[] arr, int n, int days, int m, int k) {
        int noOfB = 0;
        
        int cnt = 0;
        
        // count the number of bouquets
        for(int i=0; i < n; i++) {
            if(arr[i] <= days) {
                cnt++;
            }
            else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        
        noOfB += (cnt / k);
        
        return noOfB >= m;
    }
    
}

