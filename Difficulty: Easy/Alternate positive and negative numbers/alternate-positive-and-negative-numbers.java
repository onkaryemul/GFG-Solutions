//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    void rearrange(ArrayList<Integer> arr) {
        // code here
        // Lists to hold positive and negative numbers
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        
        // Separating positive and negative numbers
        for(int num : arr) {
            if(num >= 0) {
                pos.add(num);
            }
            else {
                neg.add(num)
;            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>(); 
        
        // Merging lists with alternation
        int i = 0, j = 0;
        int n = pos.size(), m = neg.size();
        
        while(i < n && j < m) {
            ans.add(pos.get(i));
            i++;
            ans.add(neg.get(j));
            j++;
        }
        
        // Adding remaining positive numbers if any
        while(i < n) {
            ans.add(pos.get(i));
            i++;
        }
        
        // Adding remaining negative numbers if any
        while(j < m) {
            ans.add(neg.get(j));
            j++;
        }
        
        // Updating the original list
        arr.clear();
        arr.addAll(ans);
    }
    
}

