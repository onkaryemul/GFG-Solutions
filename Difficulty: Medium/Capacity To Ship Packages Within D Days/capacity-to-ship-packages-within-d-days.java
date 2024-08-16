//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            int D = Integer.parseInt(read.readLine());

            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr, N, D));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    // TC : O(log(sum(weights) - max(weights)) * n)
    // SC : O(1)
    
    // Binary Search on answers
    
    // function to find the least capacity of a boat to ship all weights within d days
    static int leastWeightCapacity(int[] weights, int n, int d) {
        // code here
        int low = getMax(weights, n);
        int high = getSum(weights, n);
        
        // apply binary search
        while(low <= high) {
            int mid = low + (high - low)/2; 
            
            int noOfDays = findDays(weights, n, mid); // calculate no. of  days required with mid as the capacity on the boat
            
            if(noOfDays <= d) {
                high = mid - 1; // eliminate the right half
            } 
            else {
                low = mid + 1; // eliminate the left half
            }
        }
        
        return low;
    }
    
    
    // function to calculate the no.of days required to ship all weights with given weight capacity of a ship
    private static int findDays(int[] weights, int n, int capacity) {
        int days = 1; // first day
        int load = 0;
        
        for(int i=0; i < n; i++) {
            // check if we can load the weight on the same day
            if(load + weights[i] <= capacity) {
                load += weights[i]; // load the weight on the same day
            }
            else { // load + weights[i] > capacity
                days += 1; // move to the next day
                load = weights[i]; // load the weight
            }
        }
        
        return days;
    }
    
    
    // function to find the max weights in given arr of size n
    private static int getMax(int[] weights, int n) {
        int max = weights[0];
        
        for(int i=1; i < n; i++) {
            if(max < weights[i]) {
                max = weights[i];
            }
        }
        
        return max;
    }
    
    
    // function to find the sum of weights of given arr of size n
    private static int getSum(int[] weights, int n) {
        int sum = weights[0];
        
        for(int i=1; i < n; i++) {
            sum += weights[i];
        }
        
        return sum;
    }
    
};


