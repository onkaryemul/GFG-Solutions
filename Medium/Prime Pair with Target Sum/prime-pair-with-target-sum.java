//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends


// import java.util.ArrayList;


class Solution {
    
    private static boolean isSieveComputed = false;
    
    private static final int MAX_N = 1000000;
    
    private static boolean[] isPrime;
    
    
    // Function to precompute prime numbers up to MAX_N using the Sieve of Erastosthenes
    private static void sieveOfEratosthenes(int maxN) {
        isPrime = new boolean[MAX_N+1];
        
        for(int i=2; i <= MAX_N; i++) {
            isPrime[i] = true;
        }
        
        for(int start=2; start * start <= MAX_N; start++) {
            // check if number is prime
            if(isPrime[start]) {
                // if it is prime, then cross all its multiples
                for(int multiple=start*start; multiple <= MAX_N; multiple += start) {
                    isPrime[multiple] = false;
                }
            }
        }
    }
    
    
    public static ArrayList<Integer> getPrimes(int n) {
        // code here
        if(isSieveComputed == false) {
            sieveOfEratosthenes(MAX_N);
            isSieveComputed = true;
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i=2; i <= n/2; i++) {
            if(isPrime[i] && isPrime[n-i]) {
                result.add(i);
                result.add(n-i);
                
                return result;
            }
        }
        
        result.add(-1);
        result.add(-1);
        
        return result;
    }
    
}

