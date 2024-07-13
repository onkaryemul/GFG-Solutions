//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(m * logn)
    // SC : O(n + m)
    
    
    // Dijkstra's algorithm
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
        }
        
        // Min heap -> sort based on distance (0)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        
        int[] result = new int[n+1];
        int[] parent = new int[n+1];
        
        Arrays.fill(result, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        
        result[1] = 0;
        pq.add(new int[]{0, 1});
        
        parent[1] = 1;
        
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];
            
            if(d > result[node]) {
                continue;
            }
            
            if(!adj.containsKey(node)) {
                continue;
            }
            
            for(int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int dist = neighbor[1];
                
                if(d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.add(new int[]{d+dist, adjNode});
                    parent[adjNode] = node;
                }
            }
        }
        
        
        if(result[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }
        
        
        List<Integer> path = new ArrayList<>();
        int node = n;
        int totalWeight = result[n];
        
        while(parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        
        path.add(1);
        Collections.reverse(path);
        
        List<Integer> resultPath = new ArrayList<>();
        resultPath.add(totalWeight);
        resultPath.addAll(path);
        
        return resultPath;
    }
    
}

