//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.Solve(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(max(arr) * n)
    // SC : O(1)
    
    // Binary Search on answers
    
    // function to find the minimum no. of bananas per hour that koko must eat to finish all the bananas within k hours
    public static int Solve(int[] arr, int k) {
        // code here
        int n = arr.length;
        
        int low = 1; // minimum no. of bananas per hour possible
        int high = getMax(arr, n);
        
        // apply binary search
        while(low <= high) {
            int mid = low + (high - low)/2; 
            
            int totalH = calculateTotalHours(arr, n, mid); // calcalate no. of hours taken to finish all bananas at the rate of mid bananas per hour
            
            if(totalH <= k) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    

    // function to calculate the total hours required to finish eating all bananas at given hourly rate
    private static int calculateTotalHours(int[] arr, int n, int hourly) {
        int totalH = 0;
        
        for(int i=0; i < n; i++) {
            totalH += Math.ceil((double)arr[i]/(double)hourly);
        }
        
        return totalH;
    }


    // function to find the maximum element from an array
    private static int getMax(int[] arr, int n) {
        int max = arr[0];
        
        for(int i=1; i < n; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        
        return max;
    }
    
}

