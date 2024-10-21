//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


// User function Template for Java
class Solution {

    // TC : O(n)
    // SC : O(1)
    
    // Using Bit-Manipulation
    
    // Properties of XOR:
    // x ^ x = 0
    
    // function to "count the no. of ways to split given array elements" into two non-emppty subsets such that the XOR of elements of each group is equal
    public static int countgroup(int arr[]) {
        // Complete the function
        
        // Since we need to split an array arr[] into two non-empty subsets such that
        // XOR of elements of each group => is equal
        // XOR Of group 1 = XOR of group 2
        
        // Hence, (XOR of group 1) ^ (XOR of Group 2) = 0, since both groups have same xor
        // ie. XOR of all elements from arr[] = 0 ====> then only it is possible to split 
        
        // Therefore, total possible ways to split array = 2^n, where n = size of the array
        // but, out of these, 2 pairs => that have one empty group => will not be accepted
        // Hence, no. of ways = 2^n - 2
        
        // but, half of these pairs of groups will be reverse of each other
        
        // Hence, no. of ways = (2^n - 2) / 2
        //                    = 2^(n-1) - 1
        
        int mod = (int)1e9 + 7;
        
        int n = arr.length;
        
        int xor = 0;
        for(int i=0; i < n; i++) {
            xor = xor ^ arr[i];
        }
        
        // Edge case
        // If XOR of all elements from an array is not equal to 0, then it is not possible to split an array into two equal subsets
        // hence, return 0 (0 ways to split)
        if(xor != 0) {
            return 0; 
        }
        
        // Otherwise, Xor of all elements from an array = 0
        // indicating, that it can be split into two subsets such that XOR of each group is equal
        
        // hence, total no. ways to split = 2^(n-1) - 1
        int pow = 1;
        for(int i=1; i < n; i++) { // 1 to (n-1)
            pow = (pow * 2) % mod;
        }
        
        return pow - 1;
    }
    
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int ans = obj.countgroup(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends