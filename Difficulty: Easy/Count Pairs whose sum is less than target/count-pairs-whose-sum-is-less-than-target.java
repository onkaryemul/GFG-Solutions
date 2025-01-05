//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n*logn)
    // SC : O(1)
    
    // Optimal approach
    
    // Using Sorting 
    // Using two-pointer approach
    
    // function to count the number of pairs in the array whose sum is strictly less than target
    int countPairs(int arr[], int target) {
        // Your code here
        int n = arr.length;
        
        // 1. Sort the given array
        Arrays.sort(arr);
        
        // 2. Apply two-pointer algorithm
        int start = 0, end = n-1;
        
        int cnt = 0; // no. of pairs whose sum < target
        
        while(start < end) {
            int sum = arr[start] + arr[end];
            
            if(sum >= target) {
                end--;
            } 
            else { // sum < target
                cnt += (end - start);
                start++;
            }
        }
        
        return cnt;
    }
    
}



//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends