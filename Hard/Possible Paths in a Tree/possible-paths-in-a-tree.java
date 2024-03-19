//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());

            int edges[][] = new int[n-1][3];
            for(int i = 0; i < (n-1); i++){
                String input_line[] = read.readLine().trim().split("\\s+");
                for(int j = 0; j < 3; j++){
                    edges[i][j] = Integer.parseInt(input_line[j]);
                }
            } 
            
            int q = Integer.parseInt(read.readLine());

            String input_line[] = read.readLine().trim().split("\\s+");
            int queries[]= new int[q];
            for(int i = 0; i < q; i++)
                queries[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.maximumWeight(n, edges, q, queries); 
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution { 
    
    int ans;
    int[] parent;
    int[] size;
    
    
    ArrayList<Integer> maximumWeight(int n, int edges[][], int q, int queries[]) {
        // code here    
        ans = 0;
        
        parent = new int[n+1];
        
        size = new int[n+1];
        Arrays.fill(size, 1);
        
        for(int i=0; i <= n; i++) {
            parent[i] = i;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        Map<Integer, Integer> map = new TreeMap<>(); // asc sorted
        
        // sorting the edges based on their weights in ascending order to get our work done
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        
        for(int i=0; i < n-1; i++) {
            // (k, v) - value is the number of paths in which max Wt. <= k
            map.put(edges[i][2], Union(edges[i][0], edges[i][1]));
        }
        
        
        for(int query : queries) { // q logn
            int maxWeight = 0;
            
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getKey() <= query) {
                    maxWeight = entry.getValue();
                } else {
                    break;
                }
            }
            
            res.add(maxWeight);
        }
        
        
        return res;
    }
 
    
    private int findParent(int x) {
        // Base case
        if(x == parent[x]) {
            return x;
        }
        
        return parent[x] = findParent(parent[x]); // find path compression
    }
    
    
    private int Union(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);
        
        // union by rank - bigger rank always become parent to avoid chaining
        if(size[rootA] < size[rootB]) {
            ans += size[rootA] * size[rootB];  // only change
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        else if (size[rootA] > size[rootB]) {
            ans += size[rootA] * size[rootB];
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        else {
            ans += size[rootA] * size[rootB];
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        
        return ans;
    }
    
}

