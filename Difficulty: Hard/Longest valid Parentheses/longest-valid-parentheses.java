//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // function to return the "length" of the longest valid parenthesis substring
    static int maxLength(String s) {
        // code here
        int maxLen = 0;
        int n = s.length();
        
        Stack<Integer> st = new Stack<>();
        // for '(' -> -1
        
        for(int i=0; i < n; i++) {
            if(s.charAt(i) == ')') {
                int temp = 0;
                
                while(!st.isEmpty() && st.peek() != -1) {
                    temp += st.pop();
                }
                
                // no opening brace
                // but still we need to consider "sequential valid braces" e.g. ()())
                maxLen = Math.max(maxLen, temp);
                
                if(st.isEmpty()) {
                    continue;
                }
                
                // remove opening brace
                st.pop();
                
                st.push(temp+2);
            }
            else { // s.charAt(i) == '('
                st.push(-1);
            }
        }
        
        // ()((()))
        int temp = 0;
        
        while(!st.isEmpty()) {
            if(st.peek() == -1) {
                temp = 0;
                st.pop();
            }
            else {
                temp += st.pop();
            }
            
            maxLen = Math.max(maxLen, temp);
        }
        
        return maxLen;
    }
    
}

