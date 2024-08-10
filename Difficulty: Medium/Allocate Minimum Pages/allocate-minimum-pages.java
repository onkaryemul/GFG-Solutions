//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(n, a, m));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n * log(sum(arr) - max(arr))
    // SC : O(1)
    
    
    // Binary Search
    // Maximumm no. of pages allocated to any student should be minimum
    // min(max no. of pages)
    
    
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
        // Edge case or Corner case
        // Check if book allocation is impossible -> when no. of students(m) > no. of books(n)
        if(m > n) {
            return (long)-1;
        }
        
        long low = getMax(arr);
        long high = getSum(arr);
        
        // apply binary search
        while(low <= high) {
            long mid = low + (high - low)/2;
            
            int students = countStudents(arr, mid);
            
            if(students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }


    private static int countStudents(int[] books, long pages) {
        int n = books.length; // size of books array
        
        int studentsCnt = 1; // no. of students who are allocated books
        long pagesStudent = 0; 
        
        for(int i=0; i < n; i++) {
            if(pagesStudent + books[i] <= pages) {
                pagesStudent += books[i];  // add pages to current student
            } 
            else {
                studentsCnt++; // add pages to next student
                pagesStudent = books[i];
            }
        }
        
        return studentsCnt;
    }
    
    
    // Function to get maximum element from an array
    private static long getMax(int[] arr) {
        long max = Integer.MIN_VALUE;
        
        for(int i=0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = (long)arr[i];
            }
        }
        
        return max;
    }
    
    
    // Function to get sum of all elements from an array
    private static long getSum(int[] arr) {
        long sum = 0;
        
        for(int i=0; i < arr.length; i++) {
            sum += (long)arr[i];
        }
        
        return sum;
    }

};

