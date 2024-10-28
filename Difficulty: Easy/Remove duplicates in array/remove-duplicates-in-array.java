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

            v = new Solution().removeDuplicate(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(101) ~ O(1)
    
    // Constraints :  2 <= arr[i] <= 100
    
    ArrayList<Integer> removeDuplicate(int arr[]) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        boolean[] vis = new boolean[101]; // initially, all are marked as false
        
        int n = arr.length;
        for(int i=0; i < n; i++) {
            if(vis[arr[i]] == false) {
                res.add(arr[i]);
                vis[arr[i]] = true;
            }   
        }
        
        return res;
    }
    
}


