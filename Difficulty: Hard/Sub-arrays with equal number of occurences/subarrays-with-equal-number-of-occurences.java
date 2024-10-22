//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


// User function Template for Java
class Solution {

    // TC : O(n)
    // SC : O(n), since using HashMap
    
    // Using HashMap
    // Key : difference of countX and countY, at given index
    // value : frequency of this difference

    // function to return the "no. of sub-arrays"
    // in which the no. of occurrences of x = no. of occurrences of y
    static int sameOccurrence(int arr[], int x, int y) {
        // write code here
        // Since, we need to count the subarrays in which the no. of occurrences of x = no. of occurrences of y
        // i.e. countX - countY = 0  ==> for that subarray
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 
        // since, initially count of x = 0  & count of y = 0  
        // then countX - countY = 0  ===> therefore (countX - countY, freq) = (0, 1)
        
        int cntX = 0, cntY = 0;
        
        int ans = 0; // store the "no. of subarrays" in which countX = countY
        
        int n = arr.length;
        
        for(int i=0; i < n; i++) {
            if(arr[i] == x) {
                cntX++;
            }
            else if(arr[i] == y) {
                cntY++;
            }
            
            int diff = cntX - cntY;
            // Check if map contains the diff as the key
            if(map.containsKey(diff)) {
                ans += map.get(diff);
            }
            
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        
        return ans;
    }
    
}



//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
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

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends