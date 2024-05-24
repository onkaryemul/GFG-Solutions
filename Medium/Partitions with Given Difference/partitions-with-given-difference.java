//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    private static final int MOD = 1000000007;
    
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int total = 0;
        for(int i=0; i < n; i++) {
            total += arr[i];
        }
        
        // Base cases
        if(total < d || (total - d)%2 == 1) {
            return 0;
        }
        
        int target = (total - d)/2;
        
        int[][] dp = new int[n+1][target+1];
        
        for(int i=0; i <= n; i++) {
            for(int j=0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(n, target, arr, dp);
    }
    
    
    private static int solve(int i, int target, int[] arr, int[][] dp) {
        // Base case
        if(i == 0) {
            if(target == 0) {
                return 1;
            }
            return 0;
        }
        
        // Check if already computed
        if(dp[i][target] != -1) {
            return dp[i][target];
        }
        
        dp[i][target] = solve(i-1, target, arr, dp) % MOD; // not take
        
        // Check if we can take it
        if(arr[i-1] <= target) {
            // take 
            dp[i][target] += solve(i-1, target-arr[i-1], arr, dp);
            dp[i][target] %= MOD;
        }
        
        return dp[i][target];
    }
    
}
        
  