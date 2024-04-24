//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    private static int mod = 1000000007;
    
    // TC : O(x*y)
    // SC : O(x*y)
    public static int ways(int x, int y)
    {
        // complete the function
        int[][] dp = new int[x+1][y+1];
        
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return solve(x, y, dp);
    }
    
    // Dynamic Programming -> Memoization
    private static int solve(int x, int y, int[][] dp) {
        // Base case
        if(x==0 && y==0) {
            return 1;
        }
        
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        
        int left = 0, up = 0;
        
        if(y > 0) {
            left = solve(x, y-1, dp)%mod;
        }
        
        if(x > 0) {
            up = solve(x-1, y, dp)%mod;
        }
        
        return dp[x][y] = (left + up)%mod;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int x=Integer.parseInt(elements[0]);
		    int y=Integer.parseInt(elements[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.ways(x,y));
		}
	}
}
// } Driver Code Ends