//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // TC : O(n) ~ O(1) since n is 3 digit number
    // SC : O(1)
    
    static String armstrongNumber(int n) {
        // code here
        int temp = n;
        
        int sum = 0;
        
        while(temp > 0) {
            int lastDigit = temp % 10;
            
            sum += (lastDigit * lastDigit * lastDigit);
            
            temp /= 10;
        }
        
        return sum == n ? "Yes" : "No";
    }
    
}

