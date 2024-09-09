//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // This problem is a variation of the popular "Dutch National flag algorithm". 
    
    /*
        This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  
        The rules are the following:
        
        1. arr[0….low-1] contains 0. [Extreme left part]
        2. arr[low….mid-1] contains 1.
        3. arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
        
        The middle part i.e. arr[mid….high] is the unsorted segment. 
    */

    // TC : O(n)
    // SC : O(1)
    
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int n = arr.size();
        
        int low = 0, mid = 0, high = n-1; // 3 pointers
        
        while(mid <= high) {
            if(arr.get(mid) == 0) {
                // Swapping arr[low] and arr[mid]
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);
                
                low++;
                mid++;
            }
            else if(arr.get(mid) == 1) {
                mid++;
            }
            else if(arr.get(mid) == 2) {
                // Swapping arr[mid] and arr[high]
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);
                
                high--;
            }
        }
    }
    
}

