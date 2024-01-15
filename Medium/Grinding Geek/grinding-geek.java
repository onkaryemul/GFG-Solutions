//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    
    public int max_courses(int n, int total, int[] cost) {
        // code here
        List<List<Integer>> dp = new ArrayList<>();
        
        
        for(int i=0; i<=n; i++) {
            List<Integer> row = new ArrayList<>();
            
            for(int j=0; j<=total; j++) {
                row.add(-1);
            }
            
            dp.add(row);
        }
        
        
        
        for(int i=n; i>=0; i--) {
            
            for(int j=0; j<=total; j++) {
                // for the nth row or 0th column, set dp[i][j] = 0;
                if(i==n || j==0) { 
                    dp.get(i).set(j, 0);
                } 
                else {
                    dp.get(i).set(j, dp.get(i+1).get(j)); // not take
                    // check if available cost is enough to buy a course on that day
                    if(j >= cost[i]) {
                        dp.get(i).set(j, Math.max(dp.get(i).get(j), 1 + dp.get(i+1).get(j - cost[i] + (9*cost[i] / 10))));
                    }
                }
                
            }
            
        }
        
        
        return dp.get(0).get(total);
    }
    
}



