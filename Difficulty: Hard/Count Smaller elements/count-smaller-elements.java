//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    int[] constructLowerArray(int[] arr) {
        // code here
        int n = arr.length;
        
        int[] ans = new int[n];
        
        List<Integer> list = new ArrayList<>();
        list.add(arr[n-1]);
        
        for(int i=n-2; i>=0; i--) {
            int idx = binarySearch(list, arr[i], 0, list.size()-1);
            ans[i] = idx;
            list.add(idx, arr[i]);
        }
        
        return ans;
    }
    
    
    // Binary Search
    private int binarySearch(List<Integer> list, int key, int low, int high) {
        if(low <= high) {
            int mid = low + (high-low)/2;
            if(list.get(mid) >= key) {
                return binarySearch(list, key, low, mid-1);
            }
            else {
                return binarySearch(list, key, mid+1, high);
            }
        }
        
        return low;
    }
    
}

