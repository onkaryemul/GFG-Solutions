//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        
        int[] ans = new int[n*n];
        
        int k = 0;
        int i = 0, j = 0;
        
        int upper = 1;
        
        while(k < n*n) {
            
            if(upper == 1) {
                // Traverse upper diagonal
                while(i>=0 && j<n) {
                    ans[k++] = mat[i][j];
                    if(j == n-1) { // Switch to lower diagonal starting from next row
                        i++;
                        break;
                    }
                    else if (i == 0) { // Switch to lower diagonal starting from next column
                        j++;
                        break;
                    }
                    // Move top right
                    i--;
                    j++;
                }
                
                upper = 0;
            }
            else {
                // Traverse lower diagonal
                while(i<n && j>=0) {
                    ans[k++] = mat[i][j];
                    if(i == n-1) { // Switch to upper diagonal starting from next column
                        j++;
                        break;
                    }
                    else if (j == 0) { // Switch to upper diagonal starting from next row
                        i++;
                        break;
                    }
                    // Move bottom left
                    i++;
                    j--;
                }
                
                upper = 1;
            }
        }
        
        return ans;
    }
    
}

