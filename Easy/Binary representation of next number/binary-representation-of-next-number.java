//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    // TC : O(n)
    // SC : O(n) to store resultant string
    
    String binaryNextNumber(String s) {
        // code here
        // 1. Reverse the string
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        
        int carry = 1;
        int n = sb.length();
        
        for(int i=0; i < n && carry==1; i++) {
            if(sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                carry = 0;
            }
            else {
                sb.setCharAt(i, '0');
                carry = 1;
            }
        }
        
        if(carry == 1) {
            sb.append('1');
        }
        
        // 2..Reverse the string back to original order
        sb.reverse();
        
        // 3. Remove leading zeros
        int idx = 0;
        while(idx < n && sb.charAt(idx) == '0') {
            idx++;
        }
        
        // 4. Return the substring from first non-zero character to the end
        if(idx == n) {
            return "0";
        } else {
            return sb.substring(idx);
        }
    }
    
}

