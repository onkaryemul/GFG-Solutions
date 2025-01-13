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


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Optimal approach
    
    // Using two-pointers approach ==> Greedy approach => to maximize the area of rectangle
    
    // Amount of water obtained between any two lines
    //     = min(height[i], height[j]) * dist(i, j),   since area of rectange = height(ie. length) * base (ie. breadth or width)
    //     = min(height[i], height[j]) * (j - i)                           
    
    // function to find the "maximum amount of water" that can be obtained between any two lines, together with the x-axis
    public int maxWater(int arr[]) {
        // Code Here
        int n = arr.length;
        
        // apply two-pointers technique
        int maxArea = 0; // maximum amount of water trapped between any two lines
         
        int left = 0, right = n-1;
        int area = 0;
        
        while(left < right) {
            // Math.min(arr[left], arr[right]) ==> height upto which water can be trapped
            // (right - left) => base of rectangle
            area = Math.min(arr[left], arr[right]) * (right - left); // amount of water trapped between lines arr[left] & arr[height]
            
            maxArea = Math.max(maxArea, area);
            
            // greedyily move to left or right
            if(arr[left] < arr[right]) {
                left++;
            }
            else {
                right--;
            }
        }
       
        return maxArea;
    }
    
}

