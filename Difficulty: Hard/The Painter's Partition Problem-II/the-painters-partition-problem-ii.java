//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // TC : O(n * log(sum(arr) - max(arr)))
    // SC : O(1)
    
    // Binary Search
    // Similar to Allocation of Books to Students problem
    
    // min(max time taken)
    static long minTime(int[] boards,int n,int k) {
        //code here
        long low = getMax(boards, n);
        long high = getSum(boards, n);
        
        // apply binary search
        while(low <= high) {
            long mid = low + (high - low)/2;
            
            int painters = countPainters(boards, n, mid);
            
            if(painters > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return low;
    }

    
    private static int countPainters(int[] boards, int n, long time) {
        int painters = 1;
        long boardsPainter = 0; 
        
        for(int i=0; i < n; i++) {
            if(boardsPainter + boards[i] <= time) {
                boardsPainter += boards[i];  // allocate board to current painter
            }
            else {
                // allocate board to next painter
                painters++;
                boardsPainter = boards[i];
            }
        }
        
        return painters;
    }
    

    // Function to get maximum element from an array
    private static long getMax(int[] arr, int n) {
        long max = (long)arr[0];
        
        for(int i=1; i < n; i++) {
            if(max < arr[i]) {
                max = (long)arr[i];
            }
        }
        
        return max;
    }
    
    
    // Function to get sum of all elements of an array
    private static long getSum(int[] arr, int n) {
        long sum = (long)arr[0];
        
        for(int i=1; i < n; i++) {
            sum += (long)arr[i];
        }
        
        return sum;
    }
    
}

