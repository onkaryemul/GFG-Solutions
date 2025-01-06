//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n * logn)
    // SC : O(1)
    
    // Using Sorting + 2-pointers approach
    
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        int n = arr.length;
        
        // step 1 : Sort the given array
        Arrays.sort(arr);
        
        // Step 2 : Apply 2-pointers technique
        int l = 0, h = n-1;
        
        List<Integer> res = new ArrayList<>();
        
        int minDiff = Integer.MAX_VALUE;
        
        while(l < h) {
            int sum = arr[l] + arr[h];
            
            int currDiff = Math.abs(sum - target);
            
            // Track the closer
            if(currDiff < minDiff) {
                minDiff = currDiff;
                
                res.clear();
                
                res.add(arr[l]);
                res.add(arr[h]);
            }
            
            // 3 cases
            if(sum > target) {
                h--;
            }
            else if(sum < target) {
                l++;
            }
            else { // sum == target
                return res;
            }
        }
        
        return res;
    }
    
}

