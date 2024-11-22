//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int res = obj.maximumProfit(prices);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using Greedy approach
    
    // Track the minimum starting from left to right 
    // & if we found the price on ith day greater than min price till now, 
    // then we found a profit ie. curr price - min price till now & 
    // compare it with maximum profit that we can get in max one transaction
    
    public int maximumProfit(int prices[]) {
        // Code here
        int maxProfit = 0; // maximum profit that we can get in max one transaction
        
        int buyPrice = Integer.MAX_VALUE; // minimum stock price starting from left
        
        for(int price : prices) {
            if(price < buyPrice) {
                buyPrice = price;
            }
            else {
                maxProfit = Math.max(maxProfit, price - buyPrice);
            }
        }
        
        return maxProfit;
    }
    
}

