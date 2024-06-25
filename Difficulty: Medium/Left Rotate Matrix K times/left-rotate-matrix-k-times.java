//{ Driver Code Starts
// Initial Template for java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(k, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function template for java

class Solution {
    
    // TC : O(n*m)
    // SC : O(1)
    
    int[][] rotateMatrix(int k, int mat[][]) {
        // code here
        for(int[] arr : mat) {
            rotateArrayToLeft(arr, k);
        }
        
        return mat;
    }
    
    
    private void rotateArrayToLeft(int[] arr, int k) {
        k = k%arr.length;
        
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, arr.length-k-1);
        reverse(arr, arr.length-k, arr.length-1);
    }
    
    
    private void reverse(int[] arr, int l, int r) {
        while(l <= r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    
}


/*
    int[][] rotateMatrix(int k, int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] ans = new int[n][m];
        
        k = k % m;
        
        if(k==0) return mat;
        
        for(int i=0; i<n; i++){
            int x=0;
            
            for(int j=k; j<m; j++){
                ans[i][x] = mat[i][j];
                x++;
            }
            
            for(int j=0; j<k; j++){
                ans[i][x] = mat[i][j];
                x++;
            }
        }
        
        return ans;
    }
*/

