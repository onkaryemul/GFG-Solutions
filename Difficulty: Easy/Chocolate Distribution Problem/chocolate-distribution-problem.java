//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    // TC : O(n*logn)
    // SC : O(1)
    
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a); // sort the packets
        
        long minDiff = Long.MAX_VALUE;
        
        for(int i=0; i < n-m+1; i++) {
            int j = i + m -1;
            
            if(a.get(j) - a.get(i) < minDiff) {
                minDiff = a.get(j) - a.get(i);
            }
        }
        
        return minDiff;
    }
    
}

