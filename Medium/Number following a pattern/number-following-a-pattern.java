//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    
    static String printMinNumberForPattern(String S){
        // code here
        int n = S.length();
        
        char[] ans = new char[n+1];
        int cnt = 1;
        
        for(int i=0; i<=n; i++) {
            // i==n handling 2 cases - all D in string and adding the last char in all cases
            if(i==n || S.charAt(i) == 'I') {
                // itr back for every i
                for(int j=i-1; j>=-1; j--) {
                    ans[j+1] = (char)('0' + cnt);
                    cnt++;
                    if(j>=0 && S.charAt(j)=='I') { // while itr back, break as soon as I is found
                        break;
                    }
                }
            }
        }
        
        return new String(ans);
    }
    
}
