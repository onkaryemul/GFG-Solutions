//{ Driver Code Starts


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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(sqrt(n) * logn)
    // SC : O(n)
    
    // Using Mathematical approach
    public int[] AllPrimeFactors(int N) {
        // code here
        ArrayList<Integer> primes = new ArrayList<>();
        
        for(int i=2; i*i <= N; i++) {
            if(N%i == 0) {
                primes.add(i);
                
                while(N%i == 0) {
                    N = N/i;
                }
            }
        }
        
        // Edge case/Corner Case ---> VERY Important to consider
        if(N != 1) {
            primes.add(N);
        }
        
        int[] res = new int[primes.size()];
        for(int i=0; i < res.length; i++) {
            res[i] = primes.get(i);
        }
        
        return res;
    }
    
}

