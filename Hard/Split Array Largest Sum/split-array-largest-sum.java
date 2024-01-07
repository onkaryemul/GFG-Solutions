//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    private static boolean isPossible(int mid, int[] arr, int N, int K) {
        int count = 0; // count of all possible subarray
        int sum = 0;
        
        for(int i=0; i<N; i++) {
            if(arr[i] > mid) {
                return false;
            }
            
            sum += arr[i];
            
            if(sum > mid) {
                count++;
                sum = arr[i];
            }
        }
        
        count++;
        
        // mid is achievable ans if count <= k
        return count<=K ? true : false;
    }
    
    
    // Main algorithm code
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int low = 1, high = 0;
        for(int i=0; i<N; i++) {
            high += arr[i];
        }
        
        int ans = 0;
        
        // Binary search
        while(low <= high) {
            int mid = (low+high)/2;
            
            // if this mid is possible answer
            // isPossible : finding the count of all possible subarrays (sm<=mid) to make sure our mid is an achievable answer
            if(isPossible(mid, arr, N, K)) {
                // true: count <= K
                high = mid - 1; // ans = mid is achievable - but question constrain is to find min possible answer -> lower the range
                ans = mid; 
            }
            else { // count > k
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
};

