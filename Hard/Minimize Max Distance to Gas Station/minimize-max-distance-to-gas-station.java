//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n = stations.length;
        
        double low = 0.0;
        double high = 0.0;
        
        for(int i=1; i < n; i++) {
            if(high < stations[i] - stations[i-1]) {
                high = stations[i] - stations[i-1];
            }
        }
        
        double ans = high;
        
        while(high - low > 1e-9) {
            double mid = low + (high - low)/2.0;
            
            if(check(mid, stations, k)) {
                ans = mid;
                high = mid;
            }
            else {
                low = mid;
            }
        }
        
        return ans;
    }
    
    
    private static boolean check(double mid, int[] arr, int k) {
        int n = arr.length;
        
        int count = 0;
        
        for(int i=1; i < n; i++) {
            int dist = arr[i] - arr[i-1];
            
            if(dist <= mid) {
                continue;
            }
            else {
                count += (int)(dist/mid);
            }
        }
        
        return count <= k;
    }
    
}

