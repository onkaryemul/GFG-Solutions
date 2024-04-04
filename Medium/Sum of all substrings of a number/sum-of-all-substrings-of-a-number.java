//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private static long mod = (long)1e9 + 7;
    
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
        // Your code here
        int n = s.length();
        
        long prev = 0, curr = 0;
        long sum = 0;
        
        for(int i=0; i < n; i++) {
            // curr --> represent sum of all substrings of a number till current index i
            curr = (s.charAt(i) - '0')*(i+1) + prev * 10;  // main logic
            curr %= mod;
            
            sum += curr;
            sum %= mod;
            
            prev = curr;
        }
        
        return sum;
    }
    
}

