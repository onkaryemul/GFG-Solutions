//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.Evaluate(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // TC : O(1)
    // SC : O(1)
    
    public int Evaluate(String str) {
        // Code here
        str = str.replace(" ", "");
        
        int n = str.length();
        
        String a = "";
        String b = "";
        
        // i = 0, x
        // i = 1, +
        int i = 2; 
    
        while(Character.isDigit(str.charAt(i))) {
            a = a + String.valueOf(str.charAt(i));
            i++;
        }
        
        i++; // this can be =
    
        while(i < n) {
            b = b + String.valueOf(str.charAt(i));
            i++;
        }
        
        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);
        
        return numB - numA;
    }
    
}

