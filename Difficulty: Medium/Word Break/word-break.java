//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // TC : O(N^2), where N = length of string s
    // SC : O(N)
    
    // Using Recursion + Memoization
    // Dynamic Programming
    
    private static Boolean[] dp; 
    private static int N;
    
    // function to return 1 if it is possible to break string s into a sequence of dictionary words, else return 0
    public static int wordBreak(int n, String s, ArrayList<String> dictionary ) {
        //code here
        N = s.length();
        
        dp = new Boolean[N]; // initializes boolean[] with null values
        
        return solve(0, s, dictionary) ? 1 : 0;
    }
    
    
    // Helper function
    private static boolean solve(int idx, String s, ArrayList<String> wordDict) {
        // Base case
        if(idx >= N) {
            return true;
        }
        
        if(dp[idx] != null) {
            return dp[idx];
        }
        
        // Try breaking string s from index idx
        for(int endIdx = idx+1; endIdx <= N; endIdx++) {
            String split = s.substring(idx, endIdx);
            
            // If the current split exists in wordDict & remaining string(starting from endIdx) is also breakable into wordDict, then return true
            if(wordDict.contains(split) && solve(endIdx, s, wordDict)) {
                return dp[idx] = true;
            }
        }
        
        return dp[idx] = false;
    }

}

