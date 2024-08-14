//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // Sieve of Eratosthenes
 
    // TC : O(N*log(logN))
    // SC : O(N)
    
    // Optimized approach :  TC -> O(N) + O(N*log(logN)) + O(N)
    static ArrayList<Integer> sieveOfEratosthenes(int N) {
        // code here
        ArrayList<Integer> primes = new ArrayList<>();
        
        int[] isPrime = new int[N+1];
        for(int i=2; i <= N; i++) {
            isPrime[i] = 1; // marking i as a prime
        }
        
        for(int i=2; i*i <= N; i++) { 
            // Check if i is prime or not
            if(isPrime[i] == 1) { // if yes, then mark all its multiple as non-prime
                for(int j=i*i; j <= N; j+=i) {
                    isPrime[j] = 0; // marking j as non-prime
                }
            }
        }
        
        for(int i=2; i <= N; i++) {
            if(isPrime[i] == 1) {
                primes.add(i);
            }
        }
        
        return primes;
    }
    
}

