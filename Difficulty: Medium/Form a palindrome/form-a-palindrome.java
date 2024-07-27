//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution{
    
    // TC : O(n^2)
    // SC : O(n^2)
    
    // Dynamic Programming : Recursion and Memoization
    static int countMin(String str) {
        // code here
        int n = str.length();
        
        int[][] memo = new int[n][n];
        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        
        return solve(0, n-1, memo, str);
    }
    
    
    private static int solve(int i, int j, int[][] memo, String str) {
        // Base case
        if(i >= j) {
            return 0;
        }
        
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        
        if(str.charAt(i) == str.charAt(j)) {
            return memo[i][j] = solve(i+1, j-1, memo, str);
        }
        
        return memo[i][j] = Math.min(solve(i+1, j, memo, str), solve(i, j-1, memo, str)) + 1;
    }
    
}


