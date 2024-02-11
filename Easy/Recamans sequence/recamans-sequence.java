//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        
        Set<Integer> set = new HashSet<>();
        
        al.add(0);
        set.add(0);
        
        for(int i=1; i<n; i++) {
            int ans = al.get(i-1) - i;
            
            if(ans > 0 && !set.contains(ans)) {
                al.add(ans);
                set.add(ans);
            }
            else {
                al.add(al.get(i-1) + i);
                set.add(al.get(i-1) + i);
            }
        }
        
        return al;
    }
    
}

