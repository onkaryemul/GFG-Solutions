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

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, n - 1, 2);

            Solution obj = new Solution();
            int res = obj.minimumEdgeRemove(n, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    private int ans = 0;
    
    
    private int dfs(ArrayList<Integer>[] adj, int[] vis, int start) {
        vis[start] = 1;
        int cnt = 0;
        
        for (int it : adj[start]) {
            if (vis[it] == 0) {
                int res = dfs(adj, vis, it);
                
                if (res % 2 == 0) {
                    ans++;
                } else {
                    cnt += res;
                }
            }
        }
        
        return cnt + 1;
    }


    public int minimumEdgeRemove(int n, int[][] edges) {
        // code here
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            adj[edge[0] - 1].add(edge[1] - 1);
            adj[edge[1] - 1].add(edge[0] - 1);
        }
        
        int[] vis = new int[n];
        
        dfs(adj, vis, 0);
        
        return ans;
    }
    
}

