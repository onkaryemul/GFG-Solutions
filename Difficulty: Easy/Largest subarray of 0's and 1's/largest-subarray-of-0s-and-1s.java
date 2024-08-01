//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

class Largest_Subarray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) 
                a[i] = sc.nextInt();
            

            Solution g = new Solution();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}

// } Driver Code Ends




class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // return the maximum length of the subarray with equal 0s and 1s
    int maxLen(int[] arr, int N)
    {
        // Your code here
        
        // arr[] : the input array containing 0s and 1s
        // N : size of the input array
        
        int maxLen = 0;
        
        // key: Sum, Value: Index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // 0 sum at index -1
        
        int sum = 0;
        
        for(int i=0; i < N; i++) {
            if(arr[i] == 0) {
                sum += -1;
            }
            else { // arr[i] == 1
                sum += 1;
            }
            
            if(map.containsKey(sum)) {
                int len = i - map.get(sum);
                maxLen = Math.max(maxLen, len);
            }
            else {
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }
    
}

