//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().alternateSort(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    // Using Sorting 
    // Using two-pointers approach
    
    public static ArrayList<Integer> alternateSort(int[] arr) {
        // Your code goes here
        int n = arr.length;
        
        // 1. Sort the input array arr[]
        Arrays.sort(arr);
        
        // 2. Use two-pointers approach
        int i = 0; // i => point to smallest element on the left (as arr[] is sorted)
        int j = n-1; // j => point to largest element on the right (as arr[] is sorted)
        
        // 3. Create a result list => which will store elements in the order largest, smallest, secondLargest, secondSmallest, and so on
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        while(i <= j) {
            // Check if i == j ==> for array arr[] of odd length ==> then only one element is left
            if(i == j) {
                res.add(arr[i]);
                break;
            }
            
            // add the largest element from right side
            res.add(arr[j]);
            j--;
            
            // add the smallest element from left side
            res.add(arr[i]);
            i++;
        }
        
        return res;
    }
    
}

