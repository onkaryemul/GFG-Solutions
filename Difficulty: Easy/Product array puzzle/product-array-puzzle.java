//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    // TC : O(n)
    // SC : O(n)
    
    // Using Prefix sum technique => also suffix sum technique
    
    // Simple Mathematics & simulation
    
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length;
        
        int[] prodNums = new int[n];
        Arrays.fill(prodNums, 1);
    
        // left product => using prefix sum technique
        int left = 1;
        for(int i=0; i < n; i++) {
            prodNums[i] = left;
            left = left * arr[i];
        }
        
        // right product => using suffix sum technique
        int right = 1;
        for(int i=n-1; i >= 0; i--) {
            prodNums[i] = prodNums[i] * right;
            right = right * arr[i];
        }
        
        return prodNums;
    }
    
}

