//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends

//User function Template for Java

class Solution{
    
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        // Your code here
        StringBuilder b = new StringBuilder();
        
        for(int i=0; i <= 31; i++) {
            if((n & (1 << i)) != 0) {
                b.insert(0, '1');
            }
            else {
                b.insert(0, '0');
            }
        }
        
        int idx = 0;
        
        for(int i=0; i <= 31; i++) {
            if(b.charAt(i) == '1') {
                idx = i;
                break;
            }
        }
        
        b.delete(0, idx);
        
        StringBuilder g = new StringBuilder();
        g.append(b.charAt(0));
        
        int a = b.charAt(0) - '0';
        
        int blen = b.length();
        for(int i=1; i < blen; i++) {
            int x = b.charAt(i) - '0';
            
            if(a != x) {
                g.append('1');
                a = 1;
            }
            else {
                g.append('0');
                a = 0;
            }
        }
        
        int ans = 0;
        int glen = g.length();
        
        for(int i=0; i < glen; i++) {
            ans = ans * 2 + (g.charAt(i) - '0');
        }
        
        return ans;
    }
       
}



//{ Driver Code Starts.

class GFG {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//initializing n
		    
		    Solution obj = new Solution();
		    
		    //calling grayToBinary() function
		    System.out.println(obj.grayToBinary(n));
		}
	}
}

// } Driver Code Ends