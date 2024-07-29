//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n + m)
    // SC : O(1)
    
    // Binary 2D Matrix -> Each row is sorted
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr.length; // no. of rows
        int m = arr[0].length; // no. of columns
        
        int rowIndex = -1;
        // i -> point to 0th element in row
        // j -> point to last element (m-1)th element in row
        int i = 0, j = m-1;
        
        while(i < n && j >= 0) {
            if(arr[i][j] == 1) {
                rowIndex = i;
                j--;
            }
            else {
                i++;
            }
        }
        
        return rowIndex;
    }
    
}

