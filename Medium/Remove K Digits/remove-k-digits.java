//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public String removeKdigits(String S, int K) {
        // code here
        Stack<Character> stack = new Stack<>();
        
        int n = S.length();
        
        // O(n)
        for(int i=0; i<n; i++) {
            char c = S.charAt(i);
            
            while(!stack.isEmpty() && stack.peek() > c && K>0) {
                stack.pop(); // stack is in ascending order
                K--; // number of deletion remaining
            }
            
            if(!stack.isEmpty() || c != '0') {
                stack.push(c);
            }
        }
        
        // number of deletion remaining (K) > 0
        while(!stack.isEmpty() && K>0) {
            stack.pop();
            K--;
        }
        
        // Check if stack is empty, if yes then return smallest non-negative integer (0) as string
        if(stack.isEmpty()) {
            return "0";
        }
        
        
        StringBuilder sb = new StringBuilder();
        // Appends characters one by one
        for(Character ch : stack) {
            sb.append(ch); // O(1)
        }
        
        return sb.toString();
    }
    
}

/*  
    
*/
