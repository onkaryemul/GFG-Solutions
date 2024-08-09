//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java
class GFG { 
    
    // TC : O(log(min(n, m)))
    // SC : O(1)
    
    // Using Binary search
    static double medianOfArrays(int n, int m, int a[], int b[]) {
        // Your Code Here
        // Check if n > m, then swap the arrays --> in order to perform binary search on smaller array 
        if(n > m) {
            return medianOfArrays(m, n, b, a);
        }

        
        long totalLength = (long)n + m; // total length
        long left = (n + m + 1L)/2; // length of left half
        
        // Apply binary search -> on smaller array ie. a
        int low = 0, high = n; 
        
        while(low <= high) {
            int mid1 = low + (high - low)/2; 
            int mid2 = (int)(left - mid1); 
            
            // Calculate l1, l2, r1, and r2
            int l1 = mid1 > 0 ? a[mid1-1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? b[mid2-1] : Integer.MIN_VALUE;
            int r1 = mid1 < n ? a[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < m ? b[mid2] : Integer.MAX_VALUE;
            
            // Check if the left part is valid
            if(l1 <= r2 && l2 <= r1) {
                if(totalLength % 2 == 1) { // If the total length is odd, then return only mid element
                    return Math.max(l1, l2);
                }
                else { // If the total length is even, then return average of two mid elements
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                }
            }
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }
        
        return 0; // dummy element
    }
    
}

