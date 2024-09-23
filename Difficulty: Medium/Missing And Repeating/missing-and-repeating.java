//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solve {
    
    // TC : O(n), single-pass solution
    // SC : O(1)
    
    // Using Mathematics 
    // Sum of first n natural numbers =>  Sn = (n * (n+1))/2
    // Sum of squares of first n natural numbers =>  S2n = (n * (n+1) * (2*n+1))/6
    
    // function to find the Missing and Repeating Numbers
    int[] findTwoElement(int arr[]) {
        // code here
        int n = arr.length; 
        
        // Find Sn and S2n:
        long SN = ((long)n * (n + 1)) / 2L;
        long S2N = ((long)n * (n + 1) * (2*n + 1)) / 6L;
        
        // Calculate S and S2:
        long S = 0, S2 = 0;
        for(int i=0; i < n; i++) {
            S += arr[i];
            S2 += ((long)arr[i] * (long)arr[i]);
        }
        
        // S - Sn = X - Y   =>   val1 = X - Y = S - SN
        long val1 = S - SN;
        
        // S2 - S2n = X^2 - Y^2 
        // S2 - S2n = (X-Y) * (X+Y)
        
        // (X+Y) = (S2 - S2N) / (X - Y)
        
        // val2 = X + Y   
        // val1 = X - Y
        
        // val2 = (S2 - S2N) / val1
        
        long val2 = S2 - S2N;
        // Find X + Y = (X^2 - Y^2) / (X-Y)
        val2 = val2 / val1;
        
        // Find X and Y
        // X = ((X+Y) + (X-Y)) / 2  
        //   = (val2 + val1) / 2
        // Y = X - (X - Y)
        //   = X - val1
        
        long x = (val1 + val2) / 2;  // x --> repeating 
        long y = x - val1; // y --> missing
        
        int[] ans = {(int)x, (int)y};
        return ans;
    }
    
}


/* 
    public static int[] findMissingRepeatingNumbers(int[] a) {
        int n = a.length; // size of the array
        int xr = 0;

        //Step 1: Find XOR of all elements:
        for (int i = 0; i < n; i++) {
            xr = xr ^ a[i];
            xr = xr ^ (i + 1);
        }

        //Step 2: Find the differentiating bit number:
        int number = (xr & ~(xr - 1));

        //Step 3: Group the numbers:
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            //part of 1 group:
            if ((a[i] & number) != 0) {
                one = one ^ a[i];
            }
            //part of 0 group:
            else {
                zero = zero ^ a[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            //part of 1 group:
            if ((i & number) != 0) {
                one = one ^ i;
            }
            //part of 0 group:
            else {
                zero = zero ^ i;
            }
        }

        // Last step: Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == zero) cnt++;
        }

        if (cnt == 2) 
            return new int[] {zero, one};
            
        return new int[] {one, zero};
    }
*/

