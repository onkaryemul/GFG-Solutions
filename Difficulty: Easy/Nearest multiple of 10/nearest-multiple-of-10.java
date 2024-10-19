//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends


// User function Template for Java
class Solution {

    // TC : O(n)
    // SC : O(n), for StringBuilder

    // Complete the function
    String roundToNearest(String str) {
        int n = str.length();
        
        StringBuilder sb = new StringBuilder(str);
        
        // Check if the last digit is <= 5
        if(str.charAt(n-1) <= '5') {
            sb.setCharAt(n-1, '0'); // set the last digit to '0'
            return sb.toString();
        }
        
        // Set the last digit to '0'
        sb.setCharAt(n-1, '0');
        
        // Start from the second last digit
        int i = n-2;
        
        // Handle carry-over in case of '9'
        while(i >= 0 && sb.charAt(i) == '9') {
            sb.setCharAt(i, '0');
            i--;
        }
        
        // If all the digits were '9', then prepend '1'
        if(i < 0) {
            sb.insert(0, '1');
        }
        else {
            // Increase the current digit
            sb.setCharAt(i, (char)(sb.charAt(i) + 1));
        }
        
        return sb.toString();
    }
    
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends