//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(r^2)
    // SC : O(1)
    
    int rectanglesInCircle(int r) {
        // code here 
        int ans = 0; // tracks total number of rectangles with integral l & w 
        
        // In circle, largest rectangle formed is with diagonal 2*r 
        // which passes through centre of circle 
        // Hence, diagonal^2 = length^2 * width^2, so length, width <= 2r
        
        for(int length=1; length <= 2*r; length++) {
            for(int width=1; width <= 2*r; width++) {
                double diagonal = (double)Math.sqrt((length*length) + (width*width));
                
                // Check if diagonal formed with current length & width <= 2r
                if(diagonal <= 2*r) {
                    ans++; // increment no. of rectangle that can be formed
                }
            }
        }
        
        return ans;
    }
    
};

