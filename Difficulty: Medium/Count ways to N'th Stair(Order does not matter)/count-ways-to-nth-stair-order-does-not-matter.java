//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(1)
    // SC : O(1)
    
    // Tricky Question
    public int nthStair(int n) {
        // Code here
        /*  
            // steps 1 : ways 1 (only one step can be taken)
            // steps 2 : ways 2 (all one step , one 2 step)
            // steps 3 : ways 2 (all one step , one 2 step (remaining one step doesn't create different way))
            // steps 4 : ways 3 (one way to reach step 3 and a new way unlocked as now two double steps can be taken)
            // steps 5 : ways 3 (one way to reach step 4 hence output of step 4)
            // steps 6 : ways 4 (new way unlocked 3 double steps can be taken now)
            // steps 7 : ways 4 (one way to reach step 6 hence output of step 6)
        */
        
        return 1 + n/2;
    }
    
}

