//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    
    /* 
       Time Complexity : O(K^2 * logK)
       Space Complexity : O(K^2)
    */
    
    
    // Using the technique of "Recursive merge sort" ---> using the recursive divide-and-conquer approach
    /*  
       k = no. of sorted arrays
       
       Time Complexity : O(n * logk), where n=K^2 --> total no. of element across all arrays
       
       Space Complexity : O(n + logk), logk --> recursive stack space
    */
    
    
    //Function to merge k sorted arrays
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) {
        // Write your code here
        // Given k sorted arrays arranged in the form of a matrix of size k * k
        int[] mergedArray = mergeKArraysRecursive(arr, 0, K-1);
        
        ArrayList<Integer> mergedList = new ArrayList<>();
        for(int num : mergedArray) {
            mergedList.add(num);
        }
        
        return mergedList;
    }
    
    
    // Recursive function to merge K sorted arrays
    private static int[] mergeKArraysRecursive(int[][] arr, int start, int end) {
        // Base case : If only one array is left
        if(start == end) {
            return arr[start];
        }
        
        // otherwise, apply divide & conquer approach
        
        int mid = start + (end - start)/2; // find the middle point
        
        // Recursively merge left & right halves
        int[] leftMerged = mergeKArraysRecursive(arr, start, mid);
        int[] rightMerged = mergeKArraysRecursive(arr, mid+1, end);
        
        // Merge the two halves
        return mergeTwoSortedArrays(leftMerged, rightMerged);
    }

    
    // Function to merge two sorted arrays
    private static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        int[] merged = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        
        // Merge two arrays
        while(i < n1 && j < n2) {
            if(arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            }
            else {
                merged[k++] = arr2[j++];
            }
        }
        
        // Copying remaining elements from arr1, if any
        while(i < n1) {
            merged[k++] = arr1[i++];
        }
        
        // Copy remaining elements from arr2, if any
        while(j < n2) {
            merged[k++] = arr2[j++];
        }
        
        return merged;
    }

}


/* 
    //Function to merge k sorted arrays
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) {
        // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] a : arr){
            for(int ele : a){
                pq.offer(ele);
            }
        }
        
        ArrayList<Integer>list = new ArrayList<>(K*K);
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        
        return list;
    }
*/


