//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(m*n)
    // SC : O(m*n), for storing spiral order of matrix
    
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        int m = matrix.length; // no. of rows
        int n = matrix[0].length; // no. of columns
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int top = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;
        
        int dir = 0;
        // dir = 0 : Left to right (const = top)
        // dir = 1 : Top to down (const = right)
        // dir = 2 : Right to left (const = down)
        // dir = 3 : Down to top (const = left)
        
        while(top <= down && left <= right) {
            if(dir == 0) { // left to right, Row(top) = constant
                for(int i=left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            }
            
            if(dir == 1) { // top to down, column(right) = constant
                for(int i=top; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }
            
            if(dir == 2) { // right to left, Row(down) = constant
                for(int i=right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            }
            
            if(dir == 3) { // down to top, column(left) = constant
                for(int i=down; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            
            dir = (dir + 1) % 4;
        }
        
        return result;
    }
    
}


