//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    // TC : O(n^2 + nlogn)
    // SC : O(1)
    
    static int threeSumClosest(int[] array, int target) {
        // code here
        int n = array.length;
        
        Arrays.sort(array);
        
        int closestSum = Integer.MAX_VALUE;
        
        // O(n^2)
        for(int i=0; i <= n-3; i++) {
            // Two-pointer approach
            int l = i+1;
            int r = n-1;
            
            while(l < r) {
                int sum = array[i] + array[l] + array[r];
                
                if(sum == target) {
                    return sum;
                }
                else if(sum < target) {
                    l++;
                }
                else {
                    // sum > target
                    r--;
                }
                
                if(Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                else if(Math.abs(target - sum) == Math.abs(target - closestSum)) {
                    closestSum = Math.max(closestSum, sum);
                }
            }
        }
        
        return closestSum;
    }
    
}


