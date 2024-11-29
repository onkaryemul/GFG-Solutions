//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    public String addBinary(String s1, String s2) {
        // code here
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(i >= 0 || j >= 0 || carry == 1){
            int bit1 = i >=0  ? s1.charAt(i) - '0' : 0;
            int bit2 = j >=0  ? s2.charAt(j) - '0' : 0;
            
            int sum = bit1 + bit2 + carry;
            
            sb.append(sum % 2);
            
            carry = sum / 2;
            
            --i;
            --j;
        }
        
        String res = sb.reverse().toString();
        
        i = 0;
        int n = res.length();
        
        while(i < n && res.charAt(i) == '0'){
            ++i;
        }
        
        if(i > 0){
            res = res.substring(i);
        }
        
        return res;
    }
    
}

