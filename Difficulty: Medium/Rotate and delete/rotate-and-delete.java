//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public static int rotateDelete(ArrayList<Integer> arr) {
        // code here
        int n = arr.size(); // size of arraylist arr
        
        int k = 1; // initially, k=1 ---> indicates first operation
        
        while(n > 1) {
            // remove last element from arr & add it to the first
            arr.add(0, arr.remove(n-1)); 
            
            int id = n - k; // index of kth last element from the last
            if(id < 0) {
                id = 0;
            }
            
            arr.remove(id);
            
            k++; // increase the operation number
            n--; // decrese the arr size by 1 --> as we are deleting one element in each operation
        }
        
        return arr.get(0); // return the single element from arr
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
            ArrayList<Integer> arr = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr.add(Integer.parseInt(token));
            }

            Solution obj = new Solution();
            int res = obj.rotateDelete(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends