//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    
    private boolean isSafe(int node, boolean[][] graph, int[] color, int n, int col) {
        for(int k=0; k<n; k++) {
            if(k!=node && graph[k][node]==true && color[k] == col) {
                return false;
            }
        }
        return true;
    }
    
    // helper function -> recursive and backtracking function
    private boolean solve(int node, boolean[][] graph, int[] color, int n, int m) {
        // Base case
        if(node == n) {
            return true;
        }
        
        for(int i=1; i<=m; i++) {
            if(isSafe(node, graph, color, n, i)) {
                color[node] = i;
                // recursion 
                if(solve(node+1, graph, color, n, m) == true) {
                    return true;
                } 
                color[node] = 0; // backtracking 
            }
        }
        
        return false;
    }
    
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] color = new int[n];
        
        if(solve(0, graph, color, n, m) == true) {
            return true;
        }
        
        return false;
    }
    
}