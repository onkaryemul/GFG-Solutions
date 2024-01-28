//{ Driver Code Starts
import java.io.*;
import java.util.*;
public class Main{
 
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());
        Solution soln = new Solution();
        while(t-- > 0){
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            ot.println(soln.findNthNumer(n, k));
        }
        ot.close();
    }
  
} 
// } Driver Code Ends


class Solution{
    
    // helper function -> nCr function
    private long nCr(long n, long r) {
        long ans = 1;
        
        // nCr = n! / ((n-r)! * r!)
        for(long i=n; i > Math.max(r, n-r); i--) {
            ans *= i;
        }
        
        long den = 1;
        
        for(long i=1; i <= Math.min(r, n-r); i++) {
            den *= i;
        }
        
        ans /= den;
        
        return ans;
    }
    
    
    // Main algorithm code
    public long findNthNumer(int n, int k){
        // Code Here.
        long[][] dp = new long[63][k+1]; // dp array
        
        // filling dp array
        for(int i=0; i<63; i++) {
            for(int j=0; j < k+1; j++) {
                for(int x=0; x <= Math.min(i+1, j); x++) {
                    dp[i][j] += nCr((long)(i+1), (long)x);
                }
            }
        }
        
        // finding the position
        long pos = 0;
        
        for(int i=0; i<63; i++) {
            if(dp[i][k] >= n) {
                pos = i;
                break;
            }
        }
        
        long ans = 0;
        
        
        while(pos > -1 && n > 0) {
            // Base case
            if(pos + 1 <= k) {
                ans += n-1;
                break;
            }
            
            if(pos > 0 && dp[(int)(pos-1)][k] < n) {
                ans |= (1L << pos);
                n -= dp[(int)(pos-1)][k];
                k = Math.max(k-1, 0);
            }
            
            pos--;
        }
        
        
        return ans;
    }
    
}





