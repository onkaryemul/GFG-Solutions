//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            System.out.println(ob.countPrimes(L, R));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // Using the concept of "Sieve of Eratosthenes"
    
    // TC : O(R*log(logR))
    // SC : O(R)
    
    int countPrimes(int L, int R) {
        // code here
        int[] isPrime = new int[R+1];
    
        sieveOfEratosthenes(isPrime, R);
        
        int cnt = 0;
        for(int i=L; i <= R; i++) {
            if(isPrime[i] == 1) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    
    // Function to perform the sieve of eratosthenes
    private void sieveOfEratosthenes(int[] isPrime, int R) {
        for(int i=2; i <= R; i++) {
            isPrime[i] = 1; // mark i as a prime
        }
        
        for(int i=2; i*i <= R; i++) {
            if(isPrime[i] == 1) {
                for(int j=i*i; j <= R; j+=i) {
                    isPrime[j] = 0;
                }
            }
        }
    }
    
};

