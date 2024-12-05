//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        int n = arr.length;
        
        int l = 0;
        int r = n-1;
        
        int i = 0;
        
        while(i <= r){
            if(arr[i] == 0){
                arr[i] = arr[l];
                arr[l] = 0;
                l++;
                i++;
            }else if(arr[i] == 2){
                arr[i] = arr[r];
                arr[r] = 2;
                r--;
            }else {
                i++;
            }
        }
    }
    
}




//{ Driver Code Starts.
// } Driver Code Ends