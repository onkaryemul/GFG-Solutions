//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    // Using BFS approach
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // n -> number of nodes
        // m -> number of edges
        
        // For a graph to be a tree, it should have N nodes and N-1 edges
        if(m != n-1) {
            return false;
        }
        
        boolean[] vis = new boolean[n];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        // n nodes
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // m edges
        for(int i=0; i<m; i++) {
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
     
        
        int cnt = 1;
        int st = 0;
        
        Queue<Integer> q = new LinkedList<>();
        vis[st] = true;
        q.add(st);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int nei : adj.get(curr)) {
                if(!vis[nei]) {
                    vis[nei] = true;
                    cnt++;
                    q.add(nei);
                }
            }
        }
        
        return cnt==n ? true : false;
    }
    
}



