//{ Driver Code Starts
// Initial Template for Java.
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the stockBuyAndSell method
            int res = ob.maximumProfit(prices);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using Greedy approach 
    // Buying a stock on ith day if prices[i] < prices[i+1]
    // and selling it on i+1 th day 
    // therefore, profit earned by buying stock on ith day and selling it on (i+1)th day = prices[i+1] - prices[i]
    
    public int maximumProfit(int prices[]) {
        // code here
        int n = prices.length;
        
        int maxProfit = 0;
        
        for(int i=0; i < n-1; i++) {
            if(prices[i] < prices[i+1]) {
                maxProfit += prices[i+1] - prices[i];
            }
        }
        
        return maxProfit;
    }
    
}

