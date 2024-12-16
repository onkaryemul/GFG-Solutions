//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(log(min(n, m)))
    // SC : O(1)
    
    // Using Binary Search ==> Optimal approach
    
    public int kthElement(int a[], int b[], int k) {
        // code here
        int m = a.length;
        int n = b.length;
        
        if(m > n) {
            return kthElement(b, a, k); // greedily searching on the smallest search space
        }
        
        int left = k; // length of left half
        
        // Apply binary search ==> on smallest array ie. a[]
        int low = Math.max(0, k - n);
        int high = Math.min(k, m);
        
        while(low <= high) {
            int mid1 = low + (high - low) / 2; // (low + high) / 2 ==> no. of elements from first array
            int mid2 = left - mid1; // no. of elementws from second array
            
            // Calculate l1, l2, r1, r2
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1];
            
            int r1 = mid1 == m ? Integer.MAX_VALUE : a[mid1];
            int r2 = mid2 == n ? Integer.MAX_VALUE : b[mid2];
            
            // Check for valid condition :
            // all elements in left part <= all elements in right part
            if(l1 <= r2 && l2 <= r1) {
                 return Math.max(l1, l2);
            }
            // Eliminate the halves
            else if(l1 > r2) {
                high = mid1 - 1;
            }
            else { // l2 > r1
                low = mid1 + 1;
            }
            
        }
        
        return -1; // dummy return statement
    }
    
}


