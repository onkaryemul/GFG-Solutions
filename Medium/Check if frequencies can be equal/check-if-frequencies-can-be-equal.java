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
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    // TC : O(n)
    // SC : O(1)
    boolean sameFreq(String s) {
        // code here
        int[] freq = new int[26];
        
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }
        
        if(check(freq)) {
            return true;
        }
        
        // reduce all ch freq one by one
        for(int i=0; i<26; i++) {
            if(freq[i] > 0) {
                freq[i]--;
                
                if(check(freq)) {
                    return true;
                }
                
                freq[i]++;
            }
        }
        
        return false;
    }
    
    
    private boolean check(int[] freq) {
        int n = -1; // get firstNonZero
        
        for(int f : freq) {
            if(f > 0) {
                if(n == -1) {
                    n = f;
                }
                else if (f != n) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}