//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for (long i = 0; i < n; i++) arr[(int)i] = sc.nextLong();

            System.out.println(new Solution().inversionCount(arr, (int)n));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // Inversion count in an array using Merge sort
    
    // TC : O(n*logn)
    // SC : O(n)
    
    private static long cnt; // cnt variable to count the pairs (i, j) such i < j && arr[i] > arr[j]
    
    // arr[]: Input Array
    // N : Size of the Array arr[]
    
    // Function to count inversions in the array.
    static long inversionCount(long arr[], int n) {
        // Your Code Here
        cnt = 0;
        
        mergeSort(arr, 0, n-1); // modified merge sort
        
        return cnt;
    }
    
    
    // Function to perform merge sort
    private static void mergeSort(long[] arr, int low, int high) {
        // Base case 
        if(low >= high) {
            return;
        }
        
        // low < high
        int mid = low + (high - low)/2;
        
        mergeSort(arr, low, mid); // left half
        
        mergeSort(arr, mid+1, high); // right half
        
        merge(arr, low, mid, high); // merging two sorted halves
    }
    
    
    // Function to perform merging to two sorted halves
    private static void merge(long[] arr, int low, int mid, int high) {
        ArrayList<Long> temp = new ArrayList<>(); // temporary array
        
        int left = low; // starting index of left half of arr
        int right = mid+1; // starting index of right half of arr
        
        // Storing elements in the temporary array in a sorted manner
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            else { // arr[left] > arr[right] --> inversion pairs
                temp.add(arr[right]);
                cnt += (mid - left + 1); // update the cnt 
                right++;
            }
        }
        
        // If elements on the left half are still left
        while(left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        
        // If elements on the right half are still left
        while(right <= high) {
            temp.add(arr[right]);
            right++;
        }
        
        // transfering all elements from temporary to arr
        for(int i=low; i <= high; i++) {
            arr[i] = temp.get(i-low);
        }
    }
    
}

