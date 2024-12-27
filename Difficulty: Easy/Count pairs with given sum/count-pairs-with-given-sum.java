//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


class Solution {

    // TC : O(n)
    // SC : O(n) ==> using HashMap
    
    // Using HashMap => to keep count/frequency of elements
    // key : num
    // value : frequency of num
    
    int countPairs(int arr[], int target) {
        // Your code here
        Map<Integer, Integer> map = new HashMap<>();
        
        int cnt = 0;
        
        for(int num : arr) {
            int compliment = target - num;
            
            if(map.containsKey(compliment)) {
                cnt += map.get(compliment);
            }
            
            map.put(num, map.getOrDefault(num, 0) + 1);
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