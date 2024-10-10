//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using HashMap => store element & its first time occurring index
    
    // key : element
    // value : index (at which element appear for first time)
    
    public int maxDistance(int[] arr) {
        // Code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = arr.length;
        
        int maxDist = 0; // max distance between same elements
        
        for(int i=0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                int diff = i - map.get(arr[i]);
                maxDist = Math.max(maxDist, diff);
            }
            else {
                map.put(arr[i], i);
            }
        }
        
        return maxDist;
    }
    
}



//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends