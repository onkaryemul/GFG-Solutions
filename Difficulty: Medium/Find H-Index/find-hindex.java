//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // code here
        int n = citations.length;
        
        int[] freq = new int[n+1];
        
        for(int i=0; i<n; i++){
            if(citations[i] >= n) {
                freq[n]++;
            }
            else {
                freq[citations[i]]++;
            }
        }
        
        int Hindex = n;
        
        int num = freq[n];
        
        while(num < Hindex){
            Hindex--;
            num += freq[Hindex];
        }
        
        return Hindex;
    }
    
}


/*   
    public int hIndex(int[] citations) {
        // code here
        Arrays.sort(citations);
        
        int n = citations.length;
        
        for(int i = 0; i < n; ++i){
            if(citations[i] >= n - i){
                return n - i;
            }
        }
        
        return 0;
    }
*/

