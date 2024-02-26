//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        int len = s.length();
        
        int n = 1 << len;  // 2^n
        
        List<String> res = new ArrayList<>();
        
        
        for(int num=1; num < n; num++) {
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j < len; j++) {
                if((num & (1 << j)) > 0) {
                    sb.append(s.charAt(j));
                }
            }
            
            res.add(sb.toString());
        }
        
        
        Collections.sort(res);
        
        
        return res;
    }
    
}

