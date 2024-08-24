//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(N * W)
    // SC : O(N * W)
    
    // Dynamic Programming -> Recursion + Memoization
    
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int N = wt.length; // N = val.length --> No. of items
        
        int[][] dp = new int[N+1][W+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return knapSackUtil(W, N-1, wt, val, dp);
    }
    
    
    // Helper function
    private static int knapSackUtil(int W, int idx, int[] wt, int[] val, int[][] dp) {
        // Base case
        if(idx < 0) {
            return 0;
        }
        
        if(dp[idx][W] != -1) {
            return dp[idx][W];
        }
        
        int take = 0;
        // Check if we can take current item
        if(W - wt[idx] >= 0) {
            take = val[idx] + knapSackUtil(W-wt[idx], idx-1, wt, val, dp);
        }
        
        int notTake = knapSackUtil(W, idx-1, wt, val, dp);
        
        return dp[idx][W] = Math.max(take, notTake);
    }
    
}


/*
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        int n = wt.length;
        
        //create dp array
        int dp[][]=new int[n+1][W+1];
        
        //for capacity 0 or non elements we have nothing to put or no capacity so 0
        
        //traverse
        for(int i=1;i<=n;i++){
            //j is our current capacity
            for(int j=1;j<=W;j++){
                //we have to take maximum items till now
                //but we are not able to pick this item
                //we picked the maximum ans which is available above this item
                int not_take=dp[i-1][j];
                int take=0;
                
                //check whether if we are able to pick this item
                //bag capacity is equal to or greater to weight
                if(j>=wt[i-1])
                    take=val[i-1] + dp[i-1][j-wt[i-1]];
                    
                dp[i][j]=Math.max(not_take, take);
            }
        }
        
        return dp[n][W];
    }
*/

