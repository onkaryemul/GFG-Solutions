//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] a = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.longestSubseq(n, a);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static int longestSubseq(int n, int[] a) {
        // code here
        // Initialize the dp array to store the length of the valid longest subsequence starting at each index
        int[] dp = new int[n];
        
        int ans = 0; 
        
        // Iterate from the end of the array to the beginning
        for(int i=n-1; i >= 0; i--) {
            int maxi = 0;
            
            // Check all subsequent elements to find the longest subsequence with absolute difference
            for(int j=i+1; j < n; j++) {
                if(Math.abs(a[i]-a[j]) == 1) {
                    maxi = Math.max(maxi, dp[j]);
                }    
            }
            
            // Update the dp value for the current element
            dp[i] = 1 + maxi;
            
            // Update the global maximum subsequence length
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
    
}

