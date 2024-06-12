//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.countNumberswith4(n);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n*m), where m is length of longest number n 
    // SC : O(1)
    
    public static int countNumberswith4(int n) {
        // code here
        int cnt = 0;
        
        for(int i=4; i <= n; i++) {
            int j = i;
            
            while(j > 0) {
                int digit = j%10;
                
                if(digit == 4) {
                    cnt++;
                    break;
                }
                
                j = j/10;
            }
        }
        
        return cnt;
    }
    
}

