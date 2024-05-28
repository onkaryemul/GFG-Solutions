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

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n*w)
    // SC : O(n*w)
    
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        int[][] dp = new int[n+1][w+1];
        
        for(int i=0; i <= n; i++) {
            for(int j=0; j <= w; j++) {
                dp[i][j] = -1;
            }
        }
        
        int ans = solve(0, w, cost, dp);
        
        if(ans >= 1000000000) {
            ans = -1;
        }
        
        return ans;
    }
    
    
    private static int solve(int idx, int w, int[] cost, int[][] dp) {
        // Base case
        if(w == 0) {
            return 0;
        }
        
        if(idx >= cost.length || idx + 1 > w) {
            return 1000000000; // 1e9 equivalent
        }
        
        // Memoize the previously calculated result
        if(dp[idx][w] != -1) {
            return dp[idx][w];
        }
        
        int a = 0, b = 0;
        
        if(cost[idx] != -1 && idx+1 <= w) {
            a = cost[idx] + solve(idx, w-(idx+1), cost, dp);
        }
        
        b = solve(idx+1, w, cost, dp);
        
        return dp[idx][w] = Math.min(a, b);
    }
    
}

