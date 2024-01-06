//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    
    private static final int MAX = (int)2e5 + 10;
    private static boolean isComputed = false;
    
    private static int[] sieve = new int[MAX];
    
    private static void compute() {
        Arrays.fill(sieve, MAX);
        
        sieve[1] = 1;
        
        for(int i=2; i<MAX; i++) {
            if(sieve[i] == MAX) { // for prime numbers
                sieve[i] = i; // update the smallest divisor of i as i
                // visit each multiple of i and update their smallest divisor
                for(int j=i+i; j<MAX; j+=i) {
                    sieve[j] = Math.min(sieve[j], i);
                } 
            }
        }
        
        isComputed = true; 
    }
    
    
    public static long sumOfPowers(long a, long b) {
        // code here
        
        // Check if sieve is computed already
        // ie. if smallest divisor of each number is calculated or not
        if(!isComputed) { // if not computed
            compute();
        }
        
        long ans = 0;
        
        for(int i=(int)a; i<=b; i++) {
            int curr = i;
            
            while(curr > 1) {
                ans++;
                curr = curr / sieve[curr];
            }
        }
        
        return ans;
    }
}
        
