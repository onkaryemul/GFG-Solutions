//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/


class Solution
{
    static int mod = 1000000007;
    
    
    static int solve(int i, int j, String s, String t, int n, int m, int[][] dp) {
        // Base condition
        if(j == m) {
            return 1;
        }
        
        if(i == n) {
            return 0;
        }
        
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int take = 0;
        if(s.charAt(i) == t.charAt(j)) {
            take = solve(i+1, j+1, s, t, n, m, dp);
        }
        int notTake = solve(i+1, j, s, t, n, m, dp);
        
        return dp[i][j] = (take + notTake) % mod;
    }
    
    
    static int subsequenceCount(String s, String t)
    {
	   // Your code here
	   int n = s.length();
	   int m = t.length();
	   
	   int i = 0;
	   int j = 0;
	   
	   int[][] dp = new int[n+1][m+1];
	   
	   for(int[] row : dp) {
	       Arrays.fill(row, -1);
	   }
	   
	   return solve(i, j, s, t, n, m, dp);
    }
    
}

