//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(N * M * 4^l)
    // SC : O(L), where L = length of word
    
    // Using Recursion + Backtracking
    
    private int L, M, N;
    
    private int[][] directions = {
                                    {0, 1}, // right
                                    {0, -1}, // left
                                    {1, 0}, // down
                                    {-1, 0} // top (up) 
                                 };
    
    
    // Search a Word in a 2D grid of characters
    
    // function to return true if word is found in board[][], otherwise return false
    public boolean isWordExist(char[][] board, String word) {
        // Code here
        N = board.length; // no. of rows in board
        M = board[0].length; // no. of columns in board
        
        L = word.length(); // length of word
        
        // Edge case
        if(N*M < 1) {
            return false;
        }
        
        for(int i=0; i < N; i++) {
            for(int j=0; j < M; j++) {
                if(board[i][j] == word.charAt(0) && find(0, i, j, board, word)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    // Helper function 
    // Recursion + Backtracking
    private boolean find(int idx, int i, int j, char[][] board, String word) {
        // Base case
        if(idx >= L) {
            return true;
        }
        
        // Check for boundry
        if(i < 0 || i >= N || j < 0 || j >= M || board[i][j] != word.charAt(idx) || board[i][j] == '$') {
            return false;
        }
        
        char temp = board[i][j];
        
        board[i][j] = '$';  // do => mark it as visited
        
        // explore
        for(int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            
            if(find(idx+1, newI, newJ, board, word)) {
                return true;
            }
        }
        
        board[i][j] = temp; // undo => mark it as unvisited => by rewriting original character at board[i][j]
        
        return false;
    }

}

