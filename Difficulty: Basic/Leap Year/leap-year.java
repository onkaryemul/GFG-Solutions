//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isLeap(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // TC : O(1)
    // SC : O(1)
    
    static int isLeap(int N) {
        //code here
        int year = N;
        
        /* 
            if(year % 4 == 0) {
                if(year % 100 == 0) {
                    if(year % 400 == 0) {
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
                else {
                    return 1;
                }
            }
            else {
                return 0;
            }
        */
        
        // A year is leap year, if it satisfies any of the following condition
        // 1. year % 400 == 0 --> divisible by 400
        // 2. year % 4 == 0 && year % 100 != 0 ---> divisible by 4 and not by 100
        
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return 1;
        }
        
        return 0;
    }
    
}




