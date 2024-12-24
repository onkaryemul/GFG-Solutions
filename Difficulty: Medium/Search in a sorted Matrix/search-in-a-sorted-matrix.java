//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(log(n*m)) ~ O(logn + logm)
    // SC : O(1)
    
    // Using Binary Search => Optimized approach
    
    // Total no. of elements in matrix of size n*m = n * m
    // So, search space = n*m
    // Binary Search => log2(n*m)
    
    // index in 1d array can be represented in 2d matrix as follows
    // rowNo = idx / noOfColumns
    // colNo = idx % noOfColumns
    
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length; // no. of rows
        int m = mat[0].length; // no. of columns
        
        // Apply binary search
        // considering matrix (2d) as linear (1d) array
        int low = 0, high = n*m - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            int row = mid / m; // rowNo = idx / col
            int col = mid % m; // colNo = idx % col
            
            if(mat[row][col] == x) {
                return true;
            }
            
            if(mat[row][col] < x) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return false;
    }
    
}

