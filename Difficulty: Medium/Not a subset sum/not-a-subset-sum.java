//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputArr = input.split(" ");
            int[] arr = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; i++) {
                arr[i] = Integer.parseInt(inputArr[i]);
            }

            Solution ob = new Solution();
            long ans = ob.findSmallest(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // sorted array arr[] of positive integers
    
    // function to return the "smallest positive integer" such that it "cannot be represented as the sum of elements of any subset" of the given array
    public long findSmallest(int[] arr) {
        // Your code goes here
        long ans = 1; // smallest positive integer that cannot be represented as the sum of elements of any subset
        
        int n = arr.length;
        for(int i=0; i < n; i++) {
            if(arr[i] > ans) {
                return ans; // smallest positive integer that cannot be represented as the sum of elements of any subset
            }
            ans += arr[i];
        }
        
        return ans; // smallest positive integer that cannot be represented as the sum of elements of any subset
    }
    
}



