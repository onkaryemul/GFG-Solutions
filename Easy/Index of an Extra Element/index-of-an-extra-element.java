//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        }
    }
}
// } Driver Code Ends


/* Complete the function below */
class Solution {
    
    public int findExtra(int n, int arr1[], int arr2[]) {
        // add code here.
        
        // arr1 - n elements
        // arr2 - (n-1) elements
        
        // beginning and middle extra element case
        for(int i=0; i < n-1; i++) {
            if(arr1[i] != arr2[i]) {
                return i; // index of extra element
            }
        }
        
        // ending extra element case
        return n-1;
    }

}

