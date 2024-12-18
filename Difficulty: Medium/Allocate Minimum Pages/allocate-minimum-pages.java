//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// Back-end complete function Template for Java
class Solution {
    
    // TC : O(log(sum(arr) - max(arr)) * n)
    // SC : O(1)
    
    // Using Binary search on our answers ==> on the range [max(arr), sum(arr)]
    
    // Maximum no. of pages allocated to any student should be minimum
    // min(max no. of pages)
    
    public static int findPages(int[] arr, int k) {
        // code here
        // arr[] => array of books
        // arr[i] => no. of pages in ith book
        
        // k ==> no. of students
        
        int n = arr.length; // no. of books
        
        // Edge case / Corner case
        // Check if book allocation is impossible ==> when no. of students(k) > no. of books(n)
        if(k > n) {
            return -1; // impossible to distribute n books among k students
        }
        
        long low = getMax(arr, n);
        long high = getSum(arr, n);
        
        // apply binary search on our answers ==> on the range [max(arr), sum(arr)]
        while(low <= high) {
            long mid = low + (high - low) / 2;
            
            int studentCnt = countStudents(arr, n, mid);
            
            if(studentCnt > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return (int)low;
    }

    // Helper function ==> to get total no. of students allocated the books in contiguous manner with 'mid' no. of pages allowed at max for any student
    private static int countStudents(int[] books, int n, long pages) {
        int studentsCnt = 1; // no. of students who are allocated books
        long pagesStudent = 0; 
        
        for(int i=0; i < n; i++) {
            if(pagesStudent + books[i] <= pages) {
                pagesStudent += books[i]; // add pages to current student
            }
            else {
                studentsCnt++; // add pages to next student
                pagesStudent = books[i];
            }
        }
        
        return studentsCnt;
    }
    
    
    // Helper function => to find max element of arr[] array
    private static long getMax(int[] arr, int n) {
        long maxi = (long)arr[0];
        
        for(int i=1; i < n; i++) {
            maxi = Math.max(maxi, (long)arr[i]);
        }
        
        return maxi;
    }
    
    
    // Helper function => to get the sum of all elements from the given array
    private static long getSum(int[] arr, int n) {
        long sum = arr[0];
        
        for(int i=1; i < n; i++) {
            sum += (long)arr[i];
        }
        
        return sum;
    }
    
}

