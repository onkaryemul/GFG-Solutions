//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(26) ~ O(1)
    
    // Optimal approach
    
    // Using sliding window & two-pointers technique
    
    // function to find the length of the longest substring without repeating characters
    public int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
        
        boolean[] vis = new boolean[26]; // initially, all are marked as false
        
        // apply sliding window technique
        int maxLen = Integer.MIN_VALUE;
        
        int start = 0, end = 0;
        
        while(end < n) {
            // Check if character at end is already present in current window (or substring)
            // if yes, try to remove characters from start of the window(substring) and make them visited false
            while(vis[s.charAt(end) - 'a'] == true) {
                vis[s.charAt(start) - 'a'] = false;
                start++;
            }
            
            // Include character at end into current window(substring)
            vis[s.charAt(end) - 'a'] = true;
            
            // current window length => end - start + 1
            maxLen = Math.max(maxLen, end - start + 1);
        
            end++;
        }
        
        return maxLen;
    }
    
}

