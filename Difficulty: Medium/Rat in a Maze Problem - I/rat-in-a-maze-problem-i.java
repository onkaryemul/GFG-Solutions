//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    
    private ArrayList<String> res = new ArrayList<>();
    
    // DFS(Depth First Search) Traversal technique
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        int n = mat.length; // n*n matrix
        
        // Edge case
        if(mat[0][0] == 0 || mat[n-1][n-1] == 0) {
            res.add("-1");
            return res;
        }
        
        boolean[][] visited = new boolean[n][n];
        
        String path = "";
        
        dfs(mat, 0, 0, visited, n, path);
        
        return res;
    }
    
    
    private void dfs(int[][] mat, int i, int j, boolean[][] visited, int n, String path) {
        // Check for out-of-bound
        if(i < 0 || j < 0 || i >= n || j >= n) {
            return;
        }
        
        // Check if current cell cannot be visited or is it already visited
        if(mat[i][j] == 0 || visited[i][j] == true) {
            return;
        }
           
        // Check if we reached destination
        if(i == n-1 && j == n-1) {
            res.add(path);
            return;
        }
        
        visited[i][j] = true;
        
        dfs(mat, i+1, j, visited, n, path + "D");
        dfs(mat, i, j-1, visited, n, path + "L");
        dfs(mat, i, j+1, visited, n, path + "R");
        dfs(mat, i-1, j, visited, n, path + "U");
        
        visited[i][j] = false; // backtracking
        
        return;
    }
    
}

