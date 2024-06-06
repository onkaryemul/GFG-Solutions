//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    long max_sum(int a[], int n) {
        // Your code here
        long sum = 0;
        long S0 = 0;
        
        for(int i=0; i < n; i++) {
            sum += a[i];
            S0 += (long)a[i]*i;
        }
         
        long maxSum = S0;
        long Si = S0;
        
        for(int i=1; i < n; i++) {
            long Sip1 = Si + sum - n*(long)a[n-i];
            
            maxSum = Math.max(maxSum, Sip1);
            
            Si = Sip1;
        }
        
        return maxSum;
    }
    
}

