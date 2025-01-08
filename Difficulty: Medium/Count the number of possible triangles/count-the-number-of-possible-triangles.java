//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n*logn) + O(n^2) ~ O(n^2)
    // SC : O(1)
    
    // Optimal approach
    
    // Using Two-pointers technique
    
    // Conditions for triangle to be possible (with sides a, b, c):
    // a + b > c
    // b + c > a
    // a + c > b
    
    // Now, using two-pointers technique => 
    // we will only check for one condition ie. a + b > c, 
    
    // because other two are followed by default ==>. since array will be sorted
    // therefore, a < c and b < c, [a, b, c, ...] => sorted array
    // hence, a < c + b and b < c + a ==> two conditions for triangle
    
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
        int n = arr.length;
        
        // Step 1 : Sort the array
        Arrays.sort(arr);
        
        // Step 2 : Apply two-pointers technique
        int cnt = 0; // count of no. of possible triangles
        
        for(int i=2; i < n; i++) {
            int l = 0, h = i-1;
            
            while(l < h) {
                if(arr[l] + arr[h] > arr[i]) { // a + b > c
                    cnt += (h - l);
                    h--;
                }
                else { // arr[l] + arr[h] <= arr[i], then we need to increase sum, so we need to increase left pointer
                    l++; // sum is lower. need to increase it 
                }
            }
        }
        
        return cnt;
    }
    
}


