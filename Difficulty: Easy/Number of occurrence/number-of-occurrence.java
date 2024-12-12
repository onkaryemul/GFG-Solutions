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
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(logn)
    // SC : O(1)
    
    // Using Binary Search => to count the no. of occurrences of target element in arr
    // Optimal approach
    
    int countFreq(int[] arr, int target) {
        // code here
        int n = arr.length;
        
        int first = getFirstOccurrence(arr, n, target);
        
        if(first == -1) {
            return 0;
        }
        
        int last = getLastOccurrence(arr, n, target);
        
        return last - first + 1;
    }
    
    
    // Helper function => to get index of first occurrence of target element in arr if it exists, otherwise return -1
    private int getFirstOccurrence(int[] arr, int n, int target) {
        int first = -1;
        
        int low = 0;
        int high = n-1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(arr[mid] == target) {
                first = mid;
                high = mid - 1;
            }
            else if(arr[mid] < target) {
                low = mid + 1;
            }
            else { // arr[mid] > target
                high = mid - 1;
            }
        }
        
        return first;
    }
    
    
    // Helper function => to get index of last occurrence of target element in arr if it exits, otherwise return -1
    private int getLastOccurrence(int[] arr, int n, int target) {
        int last = -1;
        
        int low = 0;
        int high = n-1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(arr[mid] == target) {
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] < target) {
                low = mid + 1;
            }
            else { // arr[mid] > target
                high = mid - 1;
            }
        }
        
        return last;
    }
    
}

