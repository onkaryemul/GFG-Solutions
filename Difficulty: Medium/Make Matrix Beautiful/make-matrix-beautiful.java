class Solution {
    
    // TC : O(3*n^2) pass solution
    // SC : O(1)
    
    // function to find minimum no. of operations to make matrix beautiful
    public static int balanceSums(int[][] mat) {
        // code here
        int n = mat.length; // n = mat[0].length, => square matrix
        
        int maxSum = 0;  // store the max sum across row or columns
        
        // find maximum sum row from all rows
        for(int row=0; row < n; row++) {
            int rowSum = 0;
            for(int col=0; col < n; col++) {
                rowSum += mat[row][col];
            }
            maxSum = Math.max(maxSum, rowSum);
        }
    
        // find maximum sum col from all columns
        for(int col=0; col < n; col++) {
            int colSum = 0;
            for(int row=0; row < n; row++) {
                colSum += mat[row][col];
            }
            maxSum = Math.max(maxSum, colSum);
        }
        
        // find the minimum no. of operations to make sum of each row and each column equal
        // Approach => make either each row equal to maxSum => ie. will make each column also equal to maxSum 
        // since same no. of operations are required to make ith row and ith column equal to maxSum
        int minOperations = 0;
        
        // Iterate through each row, and count the difference of maxSum and current row sum => this is the no. of operations that we have to do at that row to mmake it sum equal to maxSum
        for(int row=0; row < n; row++) {
            int rowSum = 0;
            for(int col=0; col < n; col++) {
                rowSum += mat[row][col];
            }
            minOperations += (maxSum - rowSum);
        }
        
        return minOperations;
    }
    
}
