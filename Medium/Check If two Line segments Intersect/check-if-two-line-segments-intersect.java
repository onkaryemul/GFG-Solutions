//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int p1[] = new int[2];
            int q1[] = new int[2];
            int p2[] = new int[2];
            int q2[] = new int[2];
            String S1[] = read.readLine().split(" ");
            p1[0] = Integer.parseInt(S1[0]);
            p1[1] = Integer.parseInt(S1[1]);
            q1[0] = Integer.parseInt(S1[2]);
            q1[1] = Integer.parseInt(S1[3]);
            String S2[] = read.readLine().split(" ");
            p2[0] = Integer.parseInt(S2[0]);
            p2[1] = Integer.parseInt(S2[1]);
            q2[0] = Integer.parseInt(S2[2]);
            q2[1] = Integer.parseInt(S2[3]);
            Solution ob = new Solution();
            String ans = ob.doIntersect(p1, q1, p2, q2);
            // if(ans)
            System.out.println(ans);
            // else
            // System.out.println("false");
        }
    }
}
// } Driver Code Ends


class Point {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


// User function Template for Java
class Solution {
    
    // Given three collinear points p, q, r
    // the function checks if point q lies on line segment 'pr'
    private boolean checkIfOnSegment(Point p, Point q, Point r) {
        if(q.x >= Math.min(p.x, r.x) && q.x <= Math.max(p.x, r.x) && 
           q.y >= Math.min(p.y, r.y) && q.y <= Math.max(p.y, r.y)) {
            return true;
        }
        
        return false;
    }
    
    
    // To find orientation of ordered triplet (p, q, r)
    // 0 --> p, q and r are collinear
    // 1 --> Clockwise
    // 2 --> Counterclockwise
    private int findOrientation(Point p, Point q, Point r) {
        long val = (long)(q.y - p.y) * (r.x - q.x) - 
                   (long)(q.x - p.x) * (r.y - q.y);
        
        if(val == 0) {
            return 0; // collinear
        }
        
        return (val > 0) ? 1 : 2; // clockwise or counterclockwise
    }
    
    
    // Main function that returns true if line segment 'p1q1' and 'p2q2' intersect
    private boolean checkIfIntersect(Point p1, Point q1, Point p2, Point q2) {
        // Find the four orientations needed for general and special cases
        int o1 = findOrientation(p1, q1, p2);
        int o2 = findOrientation(p1, q1, q2);
        int o3 = findOrientation(p2, q2, p1);
        int o4 = findOrientation(p2, q2, q1);
        
        // General case
        if(o1 != o2 && o3 != o4) {
            return true;
        }
        
        // Special case
        // p1, q1, annd p2 are collinear and p2 lies on segment p1q1
        if(o1 == 0 && checkIfOnSegment(p1, p2, q1)) {
            return true;
        }
        
        // p1, q1 and q2 are collinear and q2 lies on segment plq1
        if(o2 == 0 && checkIfOnSegment(p1, q2, q1)) {
            return true;
        }
        
        // p2, q2 and p1 are collinear and p1 lies on segment p2q2
        if(o3 == 0 && checkIfOnSegment(p2, p1, q2)) {
            return true;
        }
        
        // p2, q2 and q1 are collinear and q1 lies on segment p2q2
        if(o4 == 0  && checkIfOnSegment(p2, q1, q2)) {
            return true;
        }
        
        return false;  // Doessn't fall in any of the above cases
    }
    
    
    String doIntersect(int p1[], int q1[], int p2[], int q2[]) {
        // code here
        Point point1 = new Point(p1[0], p1[1]);
        Point point2 = new Point(q1[0], q1[1]);
        Point point3 = new Point(p2[0], p2[1]);
        Point point4 = new Point(q2[0], q2[1]);
        
        return checkIfIntersect(point1, point2, point3, point4) ? "true" : "false";
    }
    
}

