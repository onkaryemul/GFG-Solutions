//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution {
    
    // m = len(s) = length of string s
    // n = len(p) = length of string p
    
    // TC : O(m + n)
    // SC : O(26 + 26) ~ O(1)
    
    // Sliding Window & Two-pointers approach
    
    // Function to find the smallest window in the string s consisting of all the characters of string p.
    public static String smallestWindow(String s, String p) {
        // Your code here
        int slen = s.length();
        int plen = p.length();
        
        // Edge case 
        if(plen > slen) {
            return "-1";
        }
        
        int[] pa = new int[26]; // store count of characters in string p
        int[] sa = new int[26]; // store count of characters in string s, while doing sliding window
        
        for(char ch : p.toCharArray()) {
            pa[ch - 'a']++;
        } 
        
        int find = 0; // no. of characters found 
        String ans = ""; // result string storing minimum window substring from s which contains all characters from string p
        
        int i = 0, j = 0; // two pointers for sliding window
        
        while(j < slen) {
            char ch = s.charAt(j);
            
            sa[ch - 'a']++;
            
            if(sa[ch-'a'] <= pa[ch-'a']) {
                find++;
            }
            
            // Check If no. of characters found i.e find == plen
            // loop until find == plen
            while(find == plen) {
                // shrink the window size
                // Check if current window size (j-i+1) is less than previous window size (ans.length())
                if(ans.isEmpty() || j-i+1 < ans.length()) { 
                    ans = s.substring(i, j+1);
                }
                
                ch = s.charAt(i);
    
                sa[ch - 'a']--;
                
                if(sa[ch-'a'] < pa[ch-'a']) {
                    find--;
                }
                
                i++;   
            }
            
            j++;
        }
        
        return ans.isEmpty() ? "-1" : ans;
    }
    
}

