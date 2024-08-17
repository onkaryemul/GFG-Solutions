//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // TC : O((n+m)*log(n+m))
    // SC : O(1)
    
    // Shell sort --> O(log(n+m) * (n+m))
    
    //Function to merge the arrays
    public static void merge(long arr1[], long arr2[], int n, int m) {
        // code here 
        // Using the concept of Shell sort
        int len = n + m; // length of the imaginary single array
        
        // Initial gap
        int gap = (len/2) + (len%2); // to take ceil
        
        // O(log(n+m) * (n+m))
        while(gap > 0) { // O(log(n+m))
            // Place 2 pointers
            int left = 0;
            int right = left + gap;
            
            while(right < len) {
                // Case 1 : left in arr1[] & right in arr2[]
                if(left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // Case 2 : both pointers in arr2[]
                else if (left >= n) { // it is obvious that if left lies in arr2[] then right also lies in arr2[]
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // Case 3 : both pointers in arr1[]
                else { // left < n && right < n
                    swapIfGreater(arr1, arr1, left, right);
                }
                
                left++;
                right++;
            }
            
            // break if iteration gap = 1 is completed
            if(gap == 1) {
                break;
            }
            
            gap = (gap/2) + (gap%2); // otherwise, calculate the new gap
        }
        
    }
    
    
    // function to swap two elements in arr1 & arr2 if arr1[idx1] > arr2[idx2]
    private static void swapIfGreater(long[] arr1, long[] arr2, int idx1, int idx2) {
        if(arr1[idx1] > arr2[idx2]) {
            long temp = arr1[idx1];
            arr1[idx1] = arr2[idx2];
            arr2[idx2] = temp;
        }
    }

}


/* 
    public static void merge(long[] arr1, long[] arr2, int n, int m) {
        // Declare 2 pointers:
        int left = n - 1;
        int right = 0;

        // Swap the elements until arr1[left] is smaller than arr2[right]:
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                
                left--;
                right++;
            } else {
                break;
            }
        } 

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
*/


