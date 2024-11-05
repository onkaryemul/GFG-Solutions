//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);

            System.out.println("~");
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class GFG {
    
    // TC : O(n^2)
    // SC : O(1)
    
    // function to rotate square matrix[][] by 90 degrees in clockwise direction without using any extra space
    static void rotate(int matrix[][]) {
        // Code Here
        int n = matrix.length; // no.of rows = no. of columns ===> since square matrix
        
        // 1. Transpose ==>  rows will be converted to columns
        for(int i=0; i < n; i++) {
            for(int j=i; j < n; j++) {
                // swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // 2. Reverse each row  ==> so that all columns are reversed
        for(int i=0; i < n; i++) {
            reverseRow(matrix, i, n);
        }
    }
    
    
    // Helper function => to reverse ith row of given matrix
    private static void reverseRow(int[][] matrix, int i, int n) {
        int left = 0;
        int right = n-1;
        
        while(left < right) {
            // swap matrix[i][left] and matrix[i][right]
            int temp = matrix[i][left];
            matrix[i][left] = matrix[i][right];
            matrix[i][right] = temp;
            
            left++;
            right--;
        }
    }
    
    
}

