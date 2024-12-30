//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            // Reading the first array
            String line1 = read.readLine().trim();
            String[] numsStr1 = line1.split(" ");
            int[] a = new int[numsStr1.length];
            for (int i = 0; i < numsStr1.length; i++) {
                a[i] = Integer.parseInt(numsStr1[i]);
            }

            // Reading the second array
            String line2 = read.readLine().trim();
            String[] numsStr2 = line2.split(" ");
            int[] b = new int[numsStr2.length];
            for (int i = 0; i < numsStr2.length; i++) {
                b[i] = Integer.parseInt(numsStr2[i]);
            }

            // Creating an instance of the Solution class
            Solution ob = new Solution();

            // Calling doUnion method and printing the result
            System.out.println(ob.findUnion(a, b));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n + m)
    // SC : O(n + m)
    
    // Using HashSet ==> optimal approach
    
    // Union of two arrays => set containing distinct elements from both arrays
    
    public static int findUnion(int a[], int b[]) {
        // code here
        int n = a.length;
        int m = b.length;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i < n; i++) {
            set.add(a[i]);
        }
        
        for(int i=0; i < m; i++) {
            set.add(b[i]);
        }
        
        return set.size();
    }
    
}

