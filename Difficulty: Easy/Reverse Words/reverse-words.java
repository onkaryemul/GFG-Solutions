//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using StringBuilder 
    
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        int n = str.length();
        
        StringBuilder ans = new StringBuilder();
        
        int i = 0;
        while(i < n) {
            char ch = str.charAt(i);
            
            if(ch == '.') {
                i++;
                continue;
            }
            
            StringBuilder temp = new StringBuilder();
            while(i < n && str.charAt(i) != '.') {
                temp.append(str.charAt(i));
                i++;
            }
            
            ans.insert(0, temp + ".");
        }
        
        return ans.toString().substring(0, n); // deleting last character "."
    }
    
}

