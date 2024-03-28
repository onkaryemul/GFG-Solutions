//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Node {
    int v, w;
    
    Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}


class Solution {
    
    
    int findCity(int n, int m, int[][] edges,int distanceThreshold) {
        //code here
        int result = -1;
        
        List<List<Node>> adj = new ArrayList<>();
        
        for(int i=0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Constructing adjacency list
        for(int[] edge : edges) {
            adj.get(edge[0]).add(new Node(edge[1], edge[2]));
            adj.get(edge[1]).add(new Node(edge[0], edge[2])); // Considering bidirectional edges
        }
        
        int minCities = Integer.MAX_VALUE;
        
        // running dijkstras for each city
        for(int i=0; i < n; i++) {
            int[] dis = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE);
            
            dijkstra(adj, i, dis);
            
            int reachableCities = 0;
            
            for(int j=0; j < n; j++) {
                if(dis[j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            
            // tracking min
            if(reachableCities <= minCities) {
                minCities = reachableCities;
                result = i;
            }
        }
        
        // return the city with smallest number of cities that are reachable at dist <= threshold distance 
        return result; // if multiple cities, then city with the greatest label will be returned
    }
    
    
    // Dijkstra's Algorithm
    private void dijkstra(List<List<Node>> adj, int start, int[] dis) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
        
        dis[start] = 0;
        
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node currNode = pq.poll();
            
            for(Node nei : adj.get(currNode.v)) {
                if(dis[currNode.v] + nei.w < dis[nei.v]) {  
                    dis[nei.v] = dis[currNode.v] + nei.w;
                    pq.add(new Node(nei.v, dis[nei.v]));
                }
            }
        }
    }
    
}



