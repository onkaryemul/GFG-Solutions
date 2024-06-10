//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(n, nuts, bolts);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // Constraints:  1 <= n <= 9
    
    // Time Complexity: O(n) ~ O(1) since n is at max 9
    // Space Complexity: O(n) ~ O(1) since n is at max 9
    
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        // Make a char array to store ordered elements as per problem statement
        // order: { !,#,$,%,&,*,?,@,^ }
        char[] arr = {'!', '#', '$', '%', '&', '*', '?', '@', '^'};
        
        // Make a hashset to store elements from nuts array (or bolts array, since both have unique elements in different order)
        HashSet<Character> set = new HashSet<>();
        for(char ch : nuts) {
            set.add(ch);
        }
        
        int k = 0;
        
        for(int i=0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                nuts[k] = arr[i];
                bolts[k] = arr[i];
                k++;
            }
        }
    }
    
}
