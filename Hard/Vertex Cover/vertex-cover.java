//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    
    private static boolean checkCover(int n, int k, int m, ArrayList<ArrayList<Integer>> adj){
        int set = (1 << k) - 1;
        int limit = (1 << n);
        
        ArrayList<ArrayList<Boolean>> visited = new ArrayList<ArrayList<Boolean>>(n + 1);
        
        for (int i = 0; i < n + 1; i++) {
            visited.add(new ArrayList<Boolean>(n + 1));
            for (int j = 0; j < n + 1; j++) {
                visited.get(i).add(false);
            }
        }
        
        while (set < limit) {
            
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    visited.get(i).set(j, false);
                }
            }
            
            int cnt = 0;
            
            for (int j = 1, v = 1; j < limit; j = j << 1, v++) {
                if ( (set & j) != 0 ) {
                    for (int l = 1; l <= n; l++) {
                        if (adj.get(v).get(l) == 1 && !visited.get(v).get(l)) {
                            visited.get(v).set(l, true);
                            visited.get(l).set(v, true);
                            cnt++;
                        }
                    }
                }
            }
            
            if (cnt == m) {
                return true;
            }
            
            int c = set & -set;
            int r = set + c;
            set = (((r ^ set) >> 2) / c) | r;
        }
        
        return false;
    }
    
    
    // helper function
    private static int vertexCoverHelper(ArrayList<ArrayList<Integer>> adj, int n, int m) {
        int low = 1, high = n;
        
        while (high > low) {
            int mid = (low + high) >> 1;
            if (checkCover(n, mid, m, adj) == false) {
                low = mid + 1;
            } 
            else {
                high = mid;
            }
        }
        
        return low;
    }
    
    
    // Main algorithm code
    public static int vertexCover(int n, int m, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n + 1);
        
        for(int i = 0; i < n + 1; i++){
            adj.add(new ArrayList<Integer>(n + 1));
            
            for(int j = 0; j < n + 1; j++){
                adj.get(i).add(0);
            }
        }
        
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).set(edges[i][1], 1);
            adj.get(edges[i][1]).set(edges[i][0], 1);
        }
        
        return vertexCoverHelper(adj, n, m);
    }
    
}