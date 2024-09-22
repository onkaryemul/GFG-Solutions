//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
 
    // Using the concept of "KMP algorithm"
    
    // TC : O(n)
    // SC : O(n)
    
    // function to return the "length" of the longest proper prefix which is also a proper suffix
    // Note :-> Prefix & suffix can be overlapping but they should not be equal to the entire string
    int lps(String str) {
        // code here
        int n = str.length();
        
        int[] ans = new int[n]; // also called lps(longest prefix suffix) array
        
        int j = 0;
        int i = 1;
        
        while(i < n) {
            if(str.charAt(i) == str.charAt(j)) {
                ans[i] = j + 1;
                j++;
                i++;
            }
            else {
                if(j == 0) {
                    i++;
                }
                else {
                    j = ans[j-1];
                }
            }
        }
        
        return ans[n-1];   
    }
    
}

