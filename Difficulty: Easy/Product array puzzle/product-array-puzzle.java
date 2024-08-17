//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Simple Mathematics & simulation
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int n = nums.length;
        
        long[] prodNums = new long[n];
        Arrays.fill(prodNums, 1L);
        
        // left product
        long left = 1;
        for(int i=0; i < n; i++) {
            prodNums[i] = left;
            left = left * nums[i];
        }
        
        // right product
        long right = 1;
        for(int i=n-1; i >= 0; i--) {
            prodNums[i] = prodNums[i] * right;
            right = right * nums[i];
        }
        
        return prodNums;
    }
    
}

