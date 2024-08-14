//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            Solution ob = new Solution();
            int v[] = ob.gcd(a,b);
            System.out.println(v[0] + " " + v[1] + " " + v[2]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // Extended Euclidean Algorithm
    
    // TC : O(log(max(a,b)))
    // SC : O(1)
    
    static int[] gcd(int a, int b) {
        // code here
        boolean isSwapped = false;
        
        // Check if a < b, then swap a & b so that a is always >= b
        // Ensure a >= b
        if(a < b) {
            int temp = a;
            a = b; // now, a is larger
            b = temp; // now, b is smaller
            isSwapped = true;
        }
        
        int x = 0, y = 1;
        int lastx = 1, lasty = 0;
        int temp;
        
        while(b != 0) {
            int q = a/b;
            int r = a%b;
            
            a = b;
            b = r;
            
            temp = x;
            x = lastx - q*x;
            lastx = temp;
            
            temp = y;
            y = lasty - q*y;
            lasty = temp;
        }
        
        // Check if initially a & b have swapped, if yes then swap coeffients of x & y accordingly to reflect their relation
        if(isSwapped) {
            return new int[]{a, lasty, lastx};
        }
        
        return new int[]{a, lastx, lasty};
    }
    
}


