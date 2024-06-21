//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    // TC : O(len(str))
    // SC : O(1)
    
    String compareFrac(String str) {
        // Code here
        String[] arr = str.split(", ");
        
        String[] a1 = arr[0].split("/");
        String[] a2 = arr[1].split("/");
        
        long a = Long.parseLong(a1[0]);
        long b = Long.parseLong(a1[1]);
        
        long c = Long.parseLong(a2[0]);
        long d = Long.parseLong(a2[1]);
        
        double val1 = (a+0.0)/b;
        double val2 = (c+0.0)/d;
        
        if(val1 > val2) {
            return arr[0];
        }
        
        if(val2 > val1) {
            return arr[1];
        }
        
        return "equal";
    }
    
}

