//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n) => single pass solution
    // SC : O(1) 
    
    // Optimal approach =+> space optimized, constant space
    
    // Using Two-pointers technique
    
    // for every building, track leftmax & rightmax building
    // so that, total water trapped = Math.min(leftmax, rightmax) - height[i]
    
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        
        int leftMax = 0; // since arr[] containes non-negative integers
        int rightMax = 0;
        
        int totalWaterTrapped = 0;
        
        // apply two-pointers technique
        int i = 0;
        int j = n-1;
        
        while(i < j) {
            leftMax = Math.max(leftMax, arr[i]);
            rightMax = Math.max(rightMax, arr[j]);
            
            if(arr[i] <= arr[j]) {
                totalWaterTrapped += (leftMax - arr[i]);
                i++;
            }
            else { // arr[i] > arr[j]
                totalWaterTrapped += (rightMax - arr[j]);
                j--;
            }
        }
        
        return totalWaterTrapped;
    }
    
}

