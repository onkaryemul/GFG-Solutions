//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n * min(arr[i]))
    // SC : O(min(arr[i]))
    
    public String longestCommonPrefix(String arr[]) {
        // code here
        int n = arr.length;
        
        String str = arr[0];
        for(int i=1; i < n; i++) {
            str = getCommon(str, arr[i]);
        }
         
        return str.length() == 0 ? "-1" : str;
    }
    
    
    private String getCommon(String a, String b) {
        int n = a.length();
        int m = b.length();
        
        int limitIndex = Math.min(n,m);
        
        int i = 0;
        for(i=0; i < limitIndex; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                return a.substring(0, i);
            }
        }
        
        return a.substring(0, limitIndex);
    }
    
}

