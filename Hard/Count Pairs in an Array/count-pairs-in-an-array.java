//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countPairs(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {  
    
    private static int cnt = 0;
    
    static int countPairs(int arr[], int n) 
    {
        // Your code goes here
        cnt = 0;
        
        for(int i=0; i < n; i++) {
            arr[i] = i * arr[i];
        }
        
        mergeSort(arr, 0, n-1);
        
        return cnt;
    }
    
    
    private static void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            mergeAndCount(arr, low, mid, high);
        }
    }
    
    
    private static void mergeAndCount(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for(int i=0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        
        for(int i=0; i < n2; i++) {
            right[i] = arr[mid+1 + i];
        }
        
        int k = low; //
        int i = 0, j = 0;
        
        while(i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                cnt += (n1 - i); // counting inversions pairs
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        
        while(i < n1) {
            arr[k++] = left[i++];
        }
        
        while(j < n2) {
            arr[k++] = right[j++];
        }
    }
    
}

