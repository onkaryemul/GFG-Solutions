//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Split array in three equal sum subarrays
    
    // We need to "return an index pair(i, j)" in an array such that:
    // sum(arr[0...i]) = sum(arr[i+1...j]) = sum(arr[j+1...n-1]) ,   otherwise return an array {-1, -1}
    
    // Function to determine if array arr can be split into three equal sum sets.
    public List<Integer> findSplit(int[] arr) {
        // code here
        int n = arr.length;
        
        int totalSum = 0;
        for(int i=0; i < n; i++) {
            totalSum += arr[i];
        }
        
        List<Integer> res = new ArrayList<>(Arrays.asList(-1, -1));
        
        // Check if array sum is divisible by 3 ==> so that it can be split in to three equal sum subarrays
        if(totalSum % 3 != 0) { // if not divisible by 3, => indicating that it cannot be split into 3 equal sum subarrays
            return res; 
        }
        
        int targetSum = totalSum / 3; // target sum of each subarray
        
        int firstIdx = -1, secondIdx = -1;
        
        int currSum = 0;
        
        for(int i=0; i < n; i++) {
            currSum += arr[i];
            
            if(currSum == targetSum && firstIdx == -1) {
                firstIdx = i;
            }
            else if (currSum == 2 * targetSum && firstIdx != -1) {
                secondIdx = i;
                
                res.set(0, firstIdx);
                res.set(1, secondIdx);
                
                return res;
            }
        }
        
        return res;
    }
    
}


