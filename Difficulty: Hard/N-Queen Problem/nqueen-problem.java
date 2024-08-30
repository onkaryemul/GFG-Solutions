//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n! * n), eponential in nature since we are trying out all ways
    // SC : O(n)
    
    // Using Recursion + Backtracking 
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        char[][] board = new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        solveNQueens(0, n, board, ans); // starting with 0th row
        
        return ans;
    }
    
    
    // recursion + backtracking function
    private void solveNQueens(int i, int n, char[][] board, ArrayList<ArrayList<Integer>> ans) {
        // Base case: When all queens are placed in all rows
        if(i == n) {
            buildBoardConfig(board, ans, n);
            return;
        }
        
        // for ith row
        // try to place queen in j different columns
        for(int j=0; j < n; j++) {
            // Check if it is safe to place a queen at(i, j) of the board
            if(isSafe(i, j, n, board)) {
                board[i][j] = 'Q';
                solveNQueens(i+1, n, board, ans); // try to place next queen on next row (i+1)
                board[i][j] = '.'; // backtracking
            }
        }
    }
    
    
    // helper function - to check if is it safe to place a queen at given board(i, j) ie. at (row, col) place
    private boolean isSafe(int row, int col, int n, char[][] board) {
        // Check for any other queen in 'same column'
        for(int i=0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        
        // Check for any other queen in 'diagonal left direction '
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check for any other queen in 'diagonal right direction'
        for(int i=row-1, j=col+1; i>=0 && j < n; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
    
    
    // Helper function - to store configuration of board
    // storing col of each queen by going row-wise
    private void buildBoardConfig(char[][] board, ArrayList<ArrayList<Integer>> ans, int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if(board[i][j] == 'Q') {
                    temp.add(j+1);
                }
            }
        }
        
        ans.add(temp);
    }
    
}


