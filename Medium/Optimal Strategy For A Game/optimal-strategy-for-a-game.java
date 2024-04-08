//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(n, arr)); 
        }
    }
    
    
}
// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int n, int arr[])
    {
        // Your code here
        long[][] memo = new long[n+1][n+1];
        
        for(long[] x : memo) {
            Arrays.fill(x, -1);
        }
        
        return solve(0, n-1, arr, memo);
    }
    
    
    // Memoization 
    // TC : O(n^2)
    // SC : O(n^2)
    private static long solve(int i, int j, int[] arr, long[][] memo) {
        // Base case
        if(i > j) {
            return 0;
        }
        
        if(i == j) {
            return arr[i]; // return arr[j];
        }
        
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        
        // 2 calls
        // 1st call --> I will pick the ith ele
        long x = arr[i] + Math.min(solve(i+2, j, arr, memo), solve(i+1, j-1, arr, memo));
        
        // 2nd call --> I will pick the jth side
        long y = arr[j] + Math.min(solve(i, j-2, arr, memo), solve(i+1, j-1, arr, memo));
        
        return memo[i][j] = Math.max(x, y);
    }
    
}

