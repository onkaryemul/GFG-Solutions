//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String arr[] = read.readLine().trim().split("\\s+");
            double perimeter = Double.parseDouble(arr[0]);
            double area = Double.parseDouble(arr[1]);

            Solution ob = new Solution();
            double ans = ob.maxVolume(perimeter, area);
            System.out.println(String.format("%.2f", ans));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    // TC : O(1)
    // SC : O(1)


    // V = l*b*h
    // A = 2(l*b + b*h + l*h)
    // P = 4 (l + b + h)
    
    
    // for Maximum Volume of cuboid:  
    // l = b = P - Sq.root(P^2 - 24*A) / 12
    // h = (P/4) - 2*l
    

    double maxVolume(double perimeter, double area) {
        // code here
        // Calculate length
        double length = (double)(perimeter - Math.sqrt(perimeter*perimeter - 24*area)) / 12;
        
        // l = b -- for maximum volume of cuboid
    
        double height = (perimeter/4) - (2*length);
        
        double volume = length * length * height;
        
        return volume;
    }
}

