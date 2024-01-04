//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    
    // findMissingAndRepeating
    int[] findTwoElement(int arr[], int n) {
        // code here
        int x = 0, y = 0;
        
        // XOR all array elements
        for(int i=0; i<n; i++) {
            x ^= arr[i];
        }
        
        // XOR all numbers from 1 to n
        for(int i=1; i<=n; i++) {
            y ^= i;
        }
        
        // find the rightmost set bit 
        int rightmostSetBit = x ^ y;
        rightmostSetBit = rightmostSetBit & -rightmostSetBit; // Keep only the rightmost set bit
        
        int bucket1 = 0, bucket2 = 0;
        
        // Classify array numbers into two buckets based on the set bit
        for(int i=0; i<n; i++) {
            if( (arr[i] & rightmostSetBit) != 0 ) {
                bucket1 ^= arr[i];
            } else {
                bucket2 ^= arr[i];
            }
        }
        
        // classify numbers from 1 to n into two buckets based on the set bit
        for(int i=1; i<=n; i++) {
            if( (i & rightmostSetBit) != 0 ) {
                bucket1 ^= i;
            } else {
                bucket2 ^= i;
            }
        }
        
        // Determine the repeating and missing numbers
        int repeatingNumber = 0, missingNumber = 0;
        
        for(int num : arr) {
            if (num == bucket1) {
               repeatingNumber = bucket1;
               missingNumber = bucket2;
               break;
            } else if (num == bucket2) {
               repeatingNumber = bucket2;
               missingNumber = bucket1;
               break;
            }
        }
        
        int[] res = new int[2];
        res[0] = repeatingNumber;
        res[1] = missingNumber;
        
        return res;
    }
    
}


