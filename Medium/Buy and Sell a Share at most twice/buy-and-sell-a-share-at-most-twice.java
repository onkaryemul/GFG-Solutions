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
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine().trim());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


// Dynamic Programming 
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public static int maxProfit(int n, int[] price) {
        // code here
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        
        int ma = price[n-1];  // stores maximum selling price from right
        int mi = price[0];  // stores minimum cost price from left
        
        // right to left 
        // 1st Transaction --->  dp[i] : maximum profit from right side till that position
        for(int i=n-2; i>=0; i--) {
            if(price[i] > ma) {
                ma = price[i];
            }
            
            dp[i] = Math.max(dp[i+1], ma - price[i]);
        }
        
        
        // left to right
        // 2nd Transaction --->  dp[i] : maximum profit from left to right + 1st transaction profit
        for(int i=1; i<n; i++) {
            if(price[i] < mi) {
                mi = price[i];
            }
            
            dp[i] = Math.max(dp[i-1], dp[i] + (price[i] - mi));
        }
        
        
        return dp[n-1];
    }
    
}
   
