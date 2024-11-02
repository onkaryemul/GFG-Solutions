//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(k)
    
    // Using HashMap
    
    // function to check if the array contains duplicates "within k distance" (k+1) elements
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
        int n = arr.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Process first (k+1) elements
        for(int i=0; i <= k; i++) {
            int ele = arr[i];
            
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            
            if(map.get(ele) > 1) {
                return  true;
            }
        }
        
        // Process rest of the elements starts from (k+1)th index of the arr
        int last = 0; // pointer to last element in current window of size (k+1) ==> k distance
        
        for(int i=k+1; i < n; i++) {
            map.put(arr[last], map.get(arr[last]) - 1); // decrease the frequency of last element in current window
            
            last++;
            
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // increase the frequency of current element
        
            if(map.get(arr[i]) > 1) {
                return true;
            }
        }
        
        return false;
    }
    
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            boolean res = obj.checkDuplicatesWithinK(arr, k);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends