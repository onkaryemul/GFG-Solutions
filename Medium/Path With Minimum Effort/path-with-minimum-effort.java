//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        int[][] dist = new int[rows][columns];
        
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        dist[0][0] = 0;
        
        pq.offer(new int[]{0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] step = pq.poll();
            int row = step[1];
            int col = step[2];
            
            if (row == rows - 1 && col == columns - 1) {
                return step[0];
            }
            
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            
            for (int[] dir : directions) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                
                if (nrow >= 0 && ncol >= 0 && nrow < rows && ncol < columns) {
                    int val = Math.max(step[0], Math.abs(heights[nrow][ncol] - heights[row][col]));
                    
                    if (val < dist[nrow][ncol]) {
                        dist[nrow][ncol] = val;
                        pq.offer(new int[]{val, nrow, ncol});
                    }
                }
            }
        }
        
        return dist[rows - 1][columns - 1];
    }
    
}

