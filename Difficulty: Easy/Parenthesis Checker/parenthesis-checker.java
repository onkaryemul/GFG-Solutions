//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using "Stack"
    
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        // add your code here
        int n = x.length();
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i < n; i++) {
            char ch = x.charAt(i);
            
            if(ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
                continue;
            }
            
            if(st.isEmpty()) {
                return false;
            }
            
            if(ch == '}') {
                if(st.peek() == '{') {
                    st.pop();
                }
                else {
                    return false;
                }
            }
            else if(ch == ')') {
                if(st.peek() == '(') {
                    st.pop();
                }
                else {
                    return false;
                }
            }
            else { // ch == ']'
                if(st.peek() == '[') {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }
        
        // If stack is empty, then all pairs are balanced, and hence return true
        if(st.isEmpty()) {
            return true;
        }
        
        // otherwise, return false
        return false;
    }
    
}

