//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		}
		
	}
}


// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(n), recursive stack space
    
    public int josephus(int n, int k) {
        //Your code here
        return josephusHelper(n, k) + 1; // since index starts from 1
    }
    
    
    private int josephusHelper(int n, int k) {
        // Base case
        if(n == 1) {
            return 0;
        }
        
        return (josephusHelper(n-1, k) + k) % n;
    }

    
    
}

