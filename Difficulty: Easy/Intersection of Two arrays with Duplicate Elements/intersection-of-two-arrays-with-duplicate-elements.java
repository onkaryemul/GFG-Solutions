//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution sol = new Solution();
            ArrayList<Integer> res = sol.intersectionWithDuplicates(a, b);

            // Sort the result
            Collections.sort(res);

            // Print the result
            if (res.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int num : res) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n*logn) + O(m*logm) + O(n + m)
    // SC : O(no. of distinct common elements in both array) => for Result list to return
    
    // Using sorting => optimal approach
    
    // Using two-pointers approach
    
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        int n = a.length;
        int m = b.length;
        
        // Sort the array a[] and b[]
        Arrays.sort(a);
        Arrays.sort(b);
        
        // applying two pointers technique
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while(i < n && j < m) {
            if(a[i] == b[j]) {
                ans.add(a[i]);
                i++;
                j++;
            }
            else if(a[i] < b[j]) {
                i++;
            }
            else {
                j++;
            }
            
            while(i > 0 && i < n && a[i] == a[i-1]) {
                i++;
            }
            
            while(j > 0 && j < m && b[j] == b[j-1]) {
                j++;
            }
        }
        
        return ans;
    }
    
}


