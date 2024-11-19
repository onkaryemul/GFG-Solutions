//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1)

    // function to return the next permutation 
    // that rearranges the numbers into the lexicographically next greater permutation
    void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        
        // i => second last element of the array
        int i = n-2; // i will point to element which is not in descending order from right
        
        while(i >= 0 && arr[i] >= arr[i+1]) {
            i--;
        }
        
        if(i >= 0) {
            int j = n-1; // last element
            
            while(j >= 0 && arr[j] <= arr[i]) {
                j--;
            }
            // loop will break when arr[j] > arr[i]
            
            // then we need to swap arr[i] & arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            reverse(arr, i+1, n-1);
        }
        else { // i < 0 ==> meaning that all numbers in arr[] are in descending order => largest permutation number possible 
            // If no such permutation exits, rearrange the numbers into the lowest possible order (ie. sorted in ascending order)
            
            // since, all numbers in arr[] => in descending order => greatest number possible
            // lowest possible order => reverse of greatest number
            reverse(arr, 0, n-1);
        }
    }
    
    
    // Helper function => to reverse the arr[] from i to j
    private void reverse(int[] arr, int i, int j) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;
            j--;
        }
    }
    
}

