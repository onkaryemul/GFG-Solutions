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
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(log(min(n, m)))
    // SC : O(1)
    
    // Binary search approach
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int m = arr1.length;
        int n = arr2.length;
        
        if(m > n) {
            return kthElement(k, arr2, arr1); // greedily searching on the smallest search space
        }
        
        int left = k; // length of left half
        
        // Apply binary search --> on smallest array ie. arr1
        int low = Math.max(0, k-n);
        int high = Math.min(k, m);
        
        while(low <= high) {
            int mid1 = (low + high) >> 1; // (low + high)/2  ->> no. of elements from first array
            int mid2 = left - mid1; // no. of elements from second array
            
            // Calculate l1, l2, r1, and r2
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : arr1[mid1-1];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : arr2[mid2-1];
            int r1 = mid1 < m ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n ? arr2[mid2] : Integer.MAX_VALUE;
            
            // Check for valid condition: all elements in left part <= all elements in right half
            if(l1 <= r2 && l2 <= r1) {
                return (long)Math.max(l1, l2);
            }
            // eliminate the halves
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else { // l2 > r1
                low = mid1 + 1;
            }
        }
        
        return 0L; // dummy statement
    }
    
}

