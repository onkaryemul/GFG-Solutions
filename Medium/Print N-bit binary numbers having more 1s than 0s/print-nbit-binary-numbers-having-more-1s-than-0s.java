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
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    // Time Complexity:- O(2^N)
    // Space Complexity:- O(2^N)
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        
        StringBuilder temp = new StringBuilder();
        
        help(N, ans, temp, 0, 0);
        
        return ans;
    }
    
    
    private void help(int N, ArrayList<String> ans, StringBuilder temp, int zero, int one) {
        // Base case
        if(temp.length() == N) {
            ans.add(temp.toString());
            return;
        }
        
        temp.append('1');
        help(N, ans, temp, zero, one+1);
        temp.deleteCharAt(temp.length()-1);
        
        if(zero < one) {
            temp.append('0');
            help(N, ans, temp, zero+1, one);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    
}




        


