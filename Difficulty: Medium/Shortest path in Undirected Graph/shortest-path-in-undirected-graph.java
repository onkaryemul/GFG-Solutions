//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // Shortest Path in an Undirected Graph having unit weight of the edges
    
    // Due to unit weight of edges, ---> we can simple BFS traversal to find shortest path from src to all the vertex 
    // since, at each level, one unit of distance get's added to ongoind dist, hence prefering BFS over standard Dijkstra's algorithm
    
    
    // TC : O(E) (for creaating the adjacency list from given list 'edges')
    //    + O(V + 2E) (for the BFS algorithm)
    //    + O(V) (for adding the final values of the shortest path in the resultant array)
    
    // Therefore, TC : O(V + 2E)
    
    // SC : O(V) + O(V) + O(V) + O(V + 2E) --> O(V + 2E)
    
    
    // Using BFS 
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        // Create an adjacency list of size n for storing the undirected graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        
        // A dist array of size n initialised with a large no. to indicate that initially all the nodes are untraversed
        int[] dist = new int[n];
        for(int i=0; i < n; i++) {
            dist[i] = (int)1e9;
        }
        
        dist[src] = 0;
        
        // BFS implementation
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            for(int nbr : adj.get(node)) {
                if(dist[node] + 1 < dist[nbr]) {
                    dist[nbr] = dist[node] + 1;
                    queue.add(nbr);
                }
            }
        }
        
        // Unreachable nodes are marked as -1
        for(int i=0; i < n; i++) {
            if(dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        
        return dist;
    }
    
}


