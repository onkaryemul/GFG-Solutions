//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Pair {
    public int first;
    public int second;
    
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


class Solution {
    
    // TC : O(n*m) + O(n*m*9)
    
    // n*m  ==> for nested loops
    // n*m*9  ==> for the overall BFS of the matrix, that will happen throughout if all the cells are filled with 1
    
    // SC : O(n*m)  ==> for visited array & 
    // max queue space (n*m) if all are marked as 1 then the maximum queue space will n*m
    
    
    // Using BFS approach
    
    private int n, m; // no. of rows & cols
    
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        n = grid.length;
        m = grid[0].length;
        
        int[][] vis = new int[n][m]; // initially, all are marked as 0 (not visited)
        
        int cnt = 0; // no. of islands
        
        for(int row=0; row < n; row++) {
            for(int col=0; col < m; col++) {
                // Check if grid[row][col] = 1 ie. land, & also is not visited
                if(grid[row][col] == '1' && vis[row][col] == 0) {
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        
        return cnt;
    }
    
    
    // Helper function => BFS
    // BFS - Breadth First Search ==> in a grid
    // in all eight directions (up, down,left, right, & all 4 diagonals)
    private void bfs(int row, int col, int[][] vis, char[][] grid) {
        vis[row][col] = 1;
        
        // Apply BFS traversal technique
        // Using queue
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(row, col));
        
        // until the queue becomes empty
        while(!queue.isEmpty()) {
            int currRow = queue.peek().first;
            int currCol = queue.peek().second;
            
            queue.remove();
            
            // traverse in the neighbours & mark them if its a land
            for(int delrow = -1; delrow <= 1; delrow++) { // row => -1 to 1
                for(int delcol = -1; delcol <= 1; delcol++) { // col => -1 to 1
                    int newRow = currRow + delrow;
                    int newCol = currCol + delcol; 
                    
                    // Check if neighbour row & column is valid, and is an unvisited land
                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1' && vis[newRow][newCol] == 0) {
                        vis[newRow][newCol] = 1;
                        queue.add(new Pair(newRow, newCol));
                    }
                }
            }
            
        }
    }
    
}

