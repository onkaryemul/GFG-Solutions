//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            boolean ans = obj.canAttend(arr);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n*logn)
    // SC : O(1)
    
    // Using Greedy approach ==> using sorting
    
    // function to check if a person can attend all the meetings such that he can attend only one meeting at a particular time
    static boolean canAttend(int[][] arr) {
        // Your code here
        int n = arr.length;
        
        // 1. Sort the given meetings array arr[][] ==> based on end time of meeting
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        
        // Start iterating from second meeting (at 1st index)
        for(int i=1; i < n; i++) {
            // a person can attend a meeting if its starting time >= the previous meetings ending time
            
            if(arr[i][0] < arr[i-1][1]) {
                return false; // overlap found, hence cannot attend this meeting
            }
        }
        
        return true; // no overlap found, hence person can attend all meetings
    }
    
}


