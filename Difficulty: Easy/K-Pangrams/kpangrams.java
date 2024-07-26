//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    boolean kPangram(String str, int k) {
        // code here
        int n = str.length();
        
        int[] arr = new int[26];
        
        int ch = 0; // tracks total number of characters in given string
        for(int i=0; i < n; i++) {
            char currChar = str.charAt(i);
            if(currChar != ' ') {
                arr[currChar - 'a'] = 1;
                ch++;
            } 
        }
        
        int c = 0; // tracks number of characters which are absent in given string
        for(int i=0; i < 26; i++) {
            if(arr[i] == 0) {
                c++;
            }
        }
        
        // Edge cases:
        // 1. If total number of characters in given string (ch) < 26, then return false
        // 2. If no. of absent characters (c) > k(max. changes), then return false
        if(ch < 26 || c > k) {
            return false;
        }
        
        return true;
    }
    
}

