//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(26) ~ O(1)
    
    String removeDups(String str) {
        // code here
        int n = str.length();
        
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < n; i++) {
            char ch = str.charAt(i);
            
            if(freq[ch - 'a'] == 0) {
                freq[ch - 'a']++;
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
    
}

