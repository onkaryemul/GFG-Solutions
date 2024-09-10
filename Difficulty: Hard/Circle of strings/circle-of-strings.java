//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    // TC : O(n)
    // SC : O(n)
    
    // Graph & Strings
    public int isCircle(String arr[]) {
        // code here
        int n = arr.length;
        
        int[] indegree = new int[26];
        int[] outdegree = new int[26];
        
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0; i < n; i++) {
            map.putIfAbsent(arr[i].charAt(0), new ArrayList<Integer>());
            
            map.get(arr[i].charAt(0)).add(i);
            
            indegree[arr[i].charAt(0) - 'a']++;
            outdegree[arr[i].charAt(arr[i].length()-1) - 'a']++;
        }
        
        
        for(char x : map.keySet()) {
            if(indegree[x - 'a'] != outdegree[x - 'a']) {
                return 0;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        
        queue.add(0);
        visited[0] = 1;
        
        int ans = 1;
        
        while(!queue.isEmpty()) {
            int index = queue.remove();
            
            char ch = arr[index].charAt(arr[index].length() - 1);
            
            for(int x : map.get(ch)) {
                if(visited[x] == 0) {
                    queue.add(x);
                    ans++;
                    visited[x] = 1;
                }
            }
        }
        
        return ans == n ? 1 : 0;
    }
    
}

