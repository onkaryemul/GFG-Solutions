//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    int DivisibleByEight(String s){
        //code here
        int len = s.length();
        
        if(len > 3) {
            String numStr = s.substring(len-3);
            int num = Integer.parseInt(numStr);
            return num % 8 == 0 ? 1 : -1;
        } else {
            int num = Integer.parseInt(s);
            return num % 8 == 0 ? 1 : -1;
        }
        
    }
    
}

