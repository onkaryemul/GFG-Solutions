//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using two pointers algorithm
    
    int countPairs(int arr[], int target) {
        // Complete the function
        int n = arr.length;
        
        // apply two pointers algorithm
        int cnt = 0;
        
        int l = 0;
        int r = n-1;
        
        while(l < r) {
            int sum = arr[l] + arr[r];
            
            if(sum == target) {
                cnt++;
                
                int nextLeft = l + 1;
                
                while(nextLeft < r && arr[nextLeft] == arr[nextLeft - 1]) {
                    cnt++;
                    nextLeft++;
                }
                
                r--;
            }
            else if(sum < target) {
                l++;
            }
            else { // sum > target
                r--;
            }
        }
        
        return cnt;
    }  
    
}



//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends