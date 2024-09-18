//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            Solution ob = new Solution();
            List<Integer> ans = ob.get(a,b);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // TC : O(1)
    // SC : O(1)
        
    // Swapping two numbers without using temporary variable
    static List<Integer> get(int a,int b) {
        // code here
        // e.g. a=10, b=20
        a = a + b; // a = 10+20 = 30
        
        b = a - b; // b = 30-20 = 10
        
        a = a - b; // a = 30-10 = 20
        
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        
        return list;
    }
    
}

