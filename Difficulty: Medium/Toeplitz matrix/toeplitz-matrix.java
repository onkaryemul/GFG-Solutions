//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            Solution g = new Solution();
            boolean b = g.isToeplitz(arr);

            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");

            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n*m)
    // SC : O(1)
    
    /*You are required to complete this method*/
    boolean isToeplitz(int mat[][]) {
        // Your code here
        int n = mat.length;
        int m = mat[0].length;
        
        // column wise
        for(int d=0; d < m; d++) {
            int ele = -1;
            
            for(int i=0, j=d; i<n && j<m; i++, j++) {
                if(ele == -1) {
                    ele = mat[i][j];
                }   
                else if (ele != mat[i][j]) {
                    return false;
                }
            }
        }
        
        // row wise
        for(int d=n-1; d > 0; d--) {
            int ele = -1;
            
            for(int i=d, j=0; i<n && j<m; i++, j++) {
                if(ele == -1) {
                    ele = mat[i][j];
                }
                else if (ele != mat[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}

