//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        int[] freq = new int[26];
        
        // count the frequency of each character in string s
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }
        
        // Iterate through string s again & Return the first character whose frequency is 1
        for(char ch : s.toCharArray()) {
            if(freq[ch-'a'] == 1) {
                return ch;
            }
        }
        
        return '$'; // If all characters in string are repeating, then return '$'
    }
    
    
}

