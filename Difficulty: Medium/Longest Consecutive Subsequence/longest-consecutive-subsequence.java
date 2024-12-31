//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using Optimal approach ==> Count sort
    
    // Longest Consecutive Subsequence
    
    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        int n = arr.length;
        
        // 0 <= arr[i] <= 10^5
        int[] freq = new int[100000 + 2]; // initially all are marked as 0
        
        int maxi = -1; // since arr[] contains non-negative integers (0,....)
        
        for(int i=0; i < n; i++) {
            freq[arr[i]]++;
            maxi = Math.max(maxi, arr[i]);
        }
        
        int maxLen = 0;
        
        int count = 0;
        
        for(int i=0; i <= maxi+1; i++) {
            if(freq[i] > 0) {
                count++; // increase the current count of consecutive subsequence
            }
            else { // if it breaks the consecutive subsequence, 
            // then calculate the max of maxlen and count (length of previous consecutive subsequence) and store it in maxlen
                maxLen = Math.max(maxLen, count);
                count = 0; // resetting the count to zero => to start new consecutive subsequence
            }
        }
        
        return maxLen;
    }
    
}

