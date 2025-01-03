//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(n) => due to HashMap data structure
    
    // Optimal approach
    
    // Using Prefix sum technique 
    // Using Reverse engineering approach
    
    // No. of subarrays having XOR of their elements as k ending at index i
    //  = total XOR of elements till index i - no. of subarrays having XOR of their elements as x (where x = XR ^ k)
    
    // therefore, x = XR ^ k 
    
    public long subarrayXor(int arr[], int k) {
        // code here
        int n = arr.length;
        
        // Key : prefix xor of all elements till index i
        // value : frequency/count of these prefix xor
        HashMap<Long, Long> map = new HashMap<>();

        long prefixXOR = 0;
        long cnt = 0; // count subarrays with XOR of their elements as k
        
        map.put(0L, 1L); // map.put(prefixXOR, cnt)
        // since, initially subarray with XOR 0 has a frequency 1
        
        for(int i=0; i < n; i++) {
            prefixXOR = prefixXOR ^ (long)arr[i]; // prefix XOR till index i
            
            // By the formula : x = XR ^ k
            long x = prefixXOR ^ (long)k;
            
            // add the occurrence of XR ^ k to the count
            // === number of subarrays ending at current index i with starting subarray has XOR as XR^k 
            // and leaving subarray with k (as required) to end at index i
            if(map.containsKey(x)) {
                cnt += map.get(x);
            }
            
            // inser the prefix xor till index i into the map
            map.put(prefixXOR, map.getOrDefault(prefixXOR, 0L) + 1L);
        }
        
        return cnt;
    }
    
}

