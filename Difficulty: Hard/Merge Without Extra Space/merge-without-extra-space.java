//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O((n+m)*log(n+m))
    // SC : O(1)
    
    // Shell Sort --> O(log(n+m) * (n+m))
    
    // Function to merge the arrays
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length;
        int m = b.length;
        
        // Using the concept of Shell sort
        int len = n + m; // length of the imaginary single array
        
        // Initial gap
        int gap = (len / 2) + (len % 2); // to take ceil
        
        // O(log(n+m) * (n+m))
        while(gap > 0) { // O(log(n+m))
            // Place 2 pointers
            int left = 0;
            int right = left + gap;
            
            while(right < len) {
                // Case 1 : left in a[] & right in b[]
                if(left < n && right >= n) {
                    swapIfGreater(a, b, left, right - n);
                }
                // Case 2 : Both pointers in b[]
                else if(left >= n) { // it is obvious  that if left lies in b[] then right also lies in b[]
                    swapIfGreater(b, b, left - n, right - n);
                }
                // Case 3 : Both pointers in a[]
                else { // left < n && right < n
                    swapIfGreater(a, a, left, right);
                }
                
                left++;
                right++;
            } 
            
            // Break if iteration gap = 1 is completed
            if(gap == 1) {
                break;
            }
            
            gap = (gap / 2) + (gap % 2); // otherwise, calculate the new gap
        }
        
        return;
    }
    
    // Helper function
    // function to swap two elements in a[] and b[] if a[idx1] > b[idx2]
    private void swapIfGreater(int[] a, int[] b, int idx1, int idx2) {
        if(a[idx1] > b[idx2]) {
            int temp = a[idx1];
            a[idx1] = b[idx2];
            b[idx2] = temp;
        }
    }
    
}

