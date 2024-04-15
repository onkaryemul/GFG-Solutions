//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String line2 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    String[] b1 = line2.trim().split("\\s+");
		    int a[]=new int[n];
		    int b[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		        b[i]=Integer.parseInt(b1[i]);
		    }
		    int q = Integer.parseInt(br.readLine());
		    int query[]=new int[q];
		    for(int i=0;i<q;i++)
		    {
		        query[i]=Integer.parseInt(br.readLine());
		    }
		    Solution ob=new Solution();
		    int ans[]=ob.countElements(a,b,n,query,q);
		    for(int i=0;i<q;i++)
		    System.out.println(ans[i]);
		    
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // TC : O(n) --> a + b + max(a) + q = 4n = n
    // SC :O(n) --> max(a) = n
    public static int[] countElements(int a[], int b[], int n, int query[], int q)
    {
        int[] ans = new int[q];
        
        int max = a[0];
        for(int x : a) {
            max = Math.max(max, x);
        }
        
        int[] hash = new int[max+1];
        
        for(int x : b) {
            if(x <= max) {
                hash[x]++;
            }
        }
        
        // Prefix sum
        for(int i=1; i <= max; i++) {
            hash[i] += hash[i-1];
        }
        
        for(int i=0; i < q; i++) {
            ans[i] = hash[a[query[i]]];
        }
        
        return ans;
    }
    
}

