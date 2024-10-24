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

            v = new Solution().modifyAndRearrangeArr(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        // Complete the function
        int n = arr.length;
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0; i < n; i++) {
            if(i+1 < n && arr[i] == arr[i+1]) {
                res.add(arr[i]*2);
                res.add(0);
                i++;
            } 
            else {
                res.add(arr[i]);
            }
        }
        
        // Take two pointers
        int i = 0, j = 0; 
        // i ==> point to zero element
        // j ==> point to non-zero element
        
        while(j < n) {
            while(i < n && res.get(i) != 0) {
                i++; // increment i till i point to zero element
            }
            
            j = Math.max(j, i); // j must be : j >= i  i.e i <= j ==> i(zero element on left) & j(non-zero element on right) 
            
            while(j < n && res.get(j) == 0) {
                j++; // increment j till j point to non-zero element
            }
            
            // Check if out-of-bound
            if(i == n || j == n) {
                break;
            }
            
            // i <= j
            // i => point to zero element
            // j => point to non-zero element
            
            res.set(i, res.get(j));
            res.set(j, 0);
        }
        
        return res;
    }
    
}


/*  
   TC : O(n)
   SC : O(n)
 
   static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
       int n = arr.length;
       
       ArrayList<Integer> res = new ArrayList<>();
       
       for(int i=0; i < n-1; i++) {
           if(arr[i] == arr[i+1]) {
               arr[i] = arr[i] * 2;
               arr[i+1] = 0;
           }
       }
       
       for(int i=0; i < n; i++) {
           if(arr[i] != 0) {
               res.add(arr[i]);
           }
       }
       
       while(res.size() < n) {
           res.add(0);
       }
       
       return res;
   }
*/


