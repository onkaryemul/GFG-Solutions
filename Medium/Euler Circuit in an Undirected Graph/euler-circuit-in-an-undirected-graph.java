//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isEularCircuitExist(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    // TC : O(v)
    // SC : O(1)
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        for(int i=0; i<v; i++) {
            if(adj.get(i).size() % 2 != 0) { // if odd number of indegress, then return false
                return false;
            }
        }
        
        return true;
    }
    
    /*  
        For Eular Circuit:
           1. Every edge should be visited exactly once
           2. Start node == end node
           
           
        Short trick:
           Every node in given graph must have even number of indegrees 
    */
}


