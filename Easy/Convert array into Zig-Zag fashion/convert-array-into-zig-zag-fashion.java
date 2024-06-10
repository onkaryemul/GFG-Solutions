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

    public static boolean isZigzag(int n, int[] arr) {
        int f = 1;

        for (int i = 1; i < n; i++) {
            if (f == 1) {
                if (arr[i - 1] > arr[i]) return false;
            } else {
                if (arr[i - 1] < arr[i]) return false;
            }
            f ^= 1;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            obj.zigZag(n, arr);

            boolean check = isZigzag(n, arr);
            if (check) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public static void zigZag(int n, int[] arr) {
        // code here
        boolean toggle = true;
        
        for(int i=0; i < n-1; i++) {
            // if toogle is true and arr[i] > arr[i+1], then swap them to ensure arr[i] < arr[i+1]
            if(toggle && arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            // if toggle is false and arr[i] < arr[i+1], then swap them to ensure arr[i] > arr[i+1]
            else if (!toggle && arr[i] < arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            
            toggle = !toggle; // toggle it
        }
        
    }
    
}
