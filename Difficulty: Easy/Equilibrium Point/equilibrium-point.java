//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(
                    token)); // Use Integer.parseInt to parse int values
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling equilibriumPoint() function
            System.out.println(obj.findEquilibrium(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n) => 2 pass solution
    // SC : O(1)
    
    // Using Prefix sum approach
    
    // Equilibrium point in an array => is an index (0 based indexing)
    // such that sum(all elements before that index i) == sum(all elements after that index)
    
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int n = arr.length;
        
        int totalSum = 0;
        for(int i=0; i < n; i++) {
            totalSum += arr[i];
        }
        
        int leftSum = 0; // will track prefix sum before index i
        int rightSum = 0; // will track suffix sum after index i ==> using totalSum - leftSum - arr[i]
        
        for(int i=0; i < n; i++) {
            // calculate rightSum after index i
            rightSum = totalSum - leftSum - arr[i];
            
            if(leftSum == rightSum) {
                return i;
            }
            
            leftSum += arr[i];
        }
        
        return -1; // if no equilibrium point exists, then return -1
    }
    
}


