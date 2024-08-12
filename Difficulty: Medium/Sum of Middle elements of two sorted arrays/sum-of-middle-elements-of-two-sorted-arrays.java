//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // Similar to "Median of 2 sorted arrays"
    
    // Using Binary search on arr1 (which is of same length as that of arr2) (smaller array)
    
    // TC : O(logn)
    // SC : O(1)
    
    // Given:  arr1.length == arr2.length  (arr1 & arr2 are of same size)
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int n = arr1.length; // n = arr2.length
        
        return findMidSum(arr1, arr2, n);
    }
    
    
    // Function to get the sum of middle elements of two sorted arrays
    private int findMidSum(int[] arr1, int[] arr2, int n) {
        // Apply binary search
        int low = 0;
        int high = n-1;
        
        while(low <= high) {
            // Calculate the partition points in both arrays
            int mid1 = low + (high - low)/2; // cut1 on arr1
            int mid2 = n - mid1; // cut2 on arr2
            
            // Get the elements around the partition points
            // Calculate l1, l2, r1, and r2
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1-1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2-1];
            int r1 = (mid1 < n) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? arr2[mid2] : Integer.MAX_VALUE;
            
            // Check if it is valid left halve
            // Check if the partition is correct
            if(l1 <= r2 && l2 <= r1) {
                // return the sum of the middle 2 elements
                return Math.max(l1, l2) + Math.min(r1, r2);
            }
            else if (l1 > r2) { // Move the high pointer to the left
                high = mid1 - 1;
            }
            else { // Move the low pointer to the right
                low = mid1 + 1;
            }
        }
        
        return 0; // dummy element ---> this case will never occur for valid input
    }
    
}



//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends