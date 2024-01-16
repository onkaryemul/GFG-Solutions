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
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int numberSequence(int m, int n)
    {
        // code here
        List<List<Integer>> dp = new ArrayList<>();
        
        // i --> max term    j --> no. of terms
        for(int i=0; i<=m; i++) {
            List<Integer> row = new ArrayList<>();
            
            for(int j=0; j<=n; j++) {
                if(i==0 || j==0 || i<j) {
                    row.add(0);
                } 
                else if(j == 1) {
                    row.add(i);
                }
                else {
                    row.add(dp.get(i-1).get(j) + dp.get(i/2).get(j-1));
                }
            }
            
            dp.add(row);
        }
        
        return dp.get(m).get(n);
    }
    
}


