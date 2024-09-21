//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;


// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // Optimized approach (Reducing time complexity for the best case)
    
    // TC : O(n^2), for worst and average cases
    // TC : O(n), for best case --> when array is already sorted
    
    //  SC : O(1)

    
    // Bubble sort algorithm
    // Push the max to the last by adjacent swaps
    
    //Function to sort the array using bubble sort algorithm.
	public static void bubbleSort(int arr[], int n) {
        //code here
        for(int i=n-1; i >= 0; i--) {
            boolean didSwap = false;
            
            for(int j=0; j <= i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    
                    didSwap = true;
                }
            }
            
            if(didSwap == false) {
                break;
            }
        }
    }
    
}



//{ Driver Code Starts.

class Sorting
{
    //method to print the Elements of the array
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		while(t>0)
		{
		    //taking total elements
			int n = sc.nextInt();
			
			//creating a new array of length n
			int arr[] = new int[n];
			
			//inserting elements to the array
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt(); 
			}
			
			
			//calling bubbleSort() method
			new Solution().bubbleSort(arr,n);
			
			//calling printArray() method
			printArray(arr);
			
		t--;	
		}
	}

}
// } Driver Code Ends