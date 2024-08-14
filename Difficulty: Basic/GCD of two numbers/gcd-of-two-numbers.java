//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int a;
            a = Integer.parseInt(br.readLine());
            
            
            int b;
            b = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.gcd(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(log(min(a, b)))
    // SC : O(1)
    
    // Using Euclidean algorithm to find gcd of two numbers in "log(min(a, b))" time complexity
    public static int gcd(int a, int b) {
        // code here
        if(b == 0) {
            return a;
        }
        
        // Check if a is smaller than b
        if(a < b) { // if yes, then make a as bigger by swapping a & b
            int temp = a;
            a = b; // now, a is bigger
            b = temp; // now, b is smaller
        }
        
        while(b != 0) {
            int remainder = a%b; 
            a = b; // value of b will go to a
            b = remainder; // value of remainder (a%b) will go to b
        }
        
        return a;
    }
    
}
        

