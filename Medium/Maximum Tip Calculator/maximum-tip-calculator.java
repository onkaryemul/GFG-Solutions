//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n*logn), since due to custom sorting 
    // SC : O(n*3) ~ O(n), due to extra space of array 
    

    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
        int[][] a = new int[n][3];

        for(int i=0; i < n; i++) {
            a[i][0] = arr[i];
            a[i][1] = brr[i];
            a[i][2] = Math.abs(arr[i] - brr[i]);
        }
        
        // Sort according to a[i][2] in descending order
        Arrays.sort(a, (p, q) -> q[2] - p[2]);
        
        long res = 0;
        
        for(int i=0; i < n; i++) {
            // Base cases
            if(x == 0) { // arr is empty
                res += a[i][1];
            }
            else if (y == 0) { // brr is empty
                res += a[i][0];
            }
            else { // take the larger value
                if(a[i][0] >= a[i][1]) {
                    res += a[i][0];
                    x--;
                }
                else {
                    res += a[i][1];
                    y--;
                }
            }
        }
    
        return res;                
    }
    
}

