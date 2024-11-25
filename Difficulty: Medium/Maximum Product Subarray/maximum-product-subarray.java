//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Function to find maximum product subarray 
    int maxProduct(int[] arr) {
        // code here
        int left = 1, right = 1;
        
        int n = arr.length;
        
        int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            left *= arr[i];
            
            maxLeft = Math.max(maxLeft, left);
            
            if(left == 0) 
               left = 1;
        }
        
        for(int i=n-1; i>=0; i--){
            right *= arr[i];
            
            maxRight = Math.max(maxRight, right);
            
            if(right == 0) 
               right = 1;
        }
        
        return Math.max(maxLeft, maxRight);
    }
    
}


