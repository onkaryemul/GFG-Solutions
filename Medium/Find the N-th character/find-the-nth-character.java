//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        // Base case
        if(r == 0) {
            return s.charAt(n);
        }
        
        char c = nthCharacter(s, r-1, n/2);
        
        if(n % 2 != 0) {
            if(c == '1') {
                return '0';
            }
            else {
                return '1';
            }
        }
        else {
            return c;
        }
        
    }
    
}

