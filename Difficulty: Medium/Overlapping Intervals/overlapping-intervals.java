//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
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
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n*logn)
    // SC : O(1)
    
    // Merge Overlapping Intervals
    
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        int n = arr.length;
        
        // Sort intervals based on the starting time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> ans = new ArrayList<>();
        
        // Add the first interval to the result
        ans.add(arr[0]);
        
        // Iterate over the remaining intervals
        for(int i=1; i < n; i++) {
            int[] lastInterval = ans.get(ans.size() - 1);
            int[] currentInterval = arr[i];
            
            // Check if the current interval overlaps with the last added interval
            if(currentInterval[0] <= lastInterval[1]) {
                // Merge the intervals by updating the end time
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            }
            else {
                // If no overlap, just add the current interval to the result
                ans.add(currentInterval);   
            }
        }
        
        
        return ans;
    }
    
}

