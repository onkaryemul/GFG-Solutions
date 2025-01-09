//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Optimal approach
    
    // Using Sliding window & 2-pointers technique
    
    // function to find the first continuous subarray which adds up to a given number
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int n = arr.length;
        
        ArrayList<Integer> ans = new ArrayList<>(); 
        // store the "1-based indices" of first continuous subarray which adds up to a given number
        // res.get(0) => starting index of subarray ===. "1-based indices"
        // res.get(1) => ending index of subarray ==> "1-based indices"
        
        // Apply sliding window & two-pointers technique
        int start = 0, end = 0;
        
        int sum = 0;
        
        while(end < n) {
            sum += arr[end]; // include the end element
            
            if(sum == target) {
                ans.add(start + 1);
                ans.add(end + 1);
                return ans;
            }
            
            // Shrink the window ==> if the sum of current subarray > target
            while(sum > target && start < end) {
                sum -= arr[start++];
                if(sum == target) {
                    ans.add(start + 1);
                    ans.add(end + 1);
                    return ans;
                }
            }
            
            end++; // expand the window
        }
        
        // if no such subarray is found whose sum equals target, then return [-1]
        ans.add(-1);
        
        return ans;
    }
    
}


