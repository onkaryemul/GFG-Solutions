//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int idx = obj.peakElement(a);
            int n = a.length;
            if (idx < 0 && idx >= n)
                System.out.println("false");
            else {
                if (n == 1 && idx == 0)
                    f = 1;
                else if (idx == 0 && a[0] > a[1])
                    f = 1;
                else if (idx == n - 1 && a[n - 1] > a[n - 2])
                    f = 1;
                else if (idx > 0 && idx < n && a[idx] > a[idx + 1] &&
                         a[idx] > a[idx - 1])
                    f = 1;
                else
                    f = 0;
                if (f == 1) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(logn)
    // SC : O(1)
    
    // Using Binary Search

    public int peakElement(int[] arr) {
        // code here
        int n = arr.length;
        
        // Edge cases
        if(n == 1) {
            return 0; // index of peak element
        }
        
        if(arr[0] > arr[1]) {
            return 0; // index of peak element
        }
        
        if(arr[n-1] > arr[n-2]) {
            return n-1; // index of peak element
        }
        
        // Binary Search ==> O(logn)
        int low = 1;
        int high = n-2;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            // If arr[mid] is the peak
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            }
            // If we are in the left 
            else if(arr[mid] > arr[mid-1]) {
                low = mid + 1;
            }
            // if we are in the right part
            // Or, arr[mid] is a common point
            else {
                high = mid - 1;
            }
        }
        
        return -1; // dummy return statement
    }
    
}

