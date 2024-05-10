//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    List<Integer> curr ;
    List<List<Integer>> ans;
    
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Code Here.
        curr = new ArrayList<>();
        ans =  new ArrayList<>();
         
        Arrays.sort(arr); // proprocessing to avoid going for same combinations
        dfs(arr, 0, k);
       
        return ans;
    }
    
    
    // Helper function: DFS traversal
    private void dfs(int arr[], int idx, int k){
        // Base case
        if(k==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        if(idx==arr.length || k<0) {
            return;
        }
        
        for(int i = idx; i<arr.length; i++){
            if(i>idx && arr[i]==arr[i-1]) {
                continue; // to avoid going for same combinations
            }
            
            curr.add(arr[i]);
                
            dfs(arr, i+1, k-arr[i]);
                
            curr.remove(curr.size()-1); //backtrack
        }
    }
    
}



