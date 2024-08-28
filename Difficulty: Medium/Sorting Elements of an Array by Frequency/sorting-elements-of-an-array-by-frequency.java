//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n*logn), for custom sorting
    // SC : O(n), for HashMap
    
    // Custom Sorting
    
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        ArrayList<Integer> list = new ArrayList<>();
        
        // key: arr[i],  Value: It's frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = arr.length;
        for(int i=0; i < n; i++) {
            list.add(arr[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        // Apply custom sort on list(arraylist)
        Collections.sort(list, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            
            if(freqA != freqB) { // if frequencies are not same,
                return freqB - freqA; // then sort in descending order of their frequency (higher frequency element first)
            }
            else { // if same frequencies, then smaller no. should come first
                return a - b; // sort in ascending order of elements
            }
        });
        
        return list;
    }
    
}



//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends