//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends


class Solution {
    
    // n = number of words in the list of strings
    // k = average/max length of word in given list of words
    
    // TC : O(n * (k*logk))
    // SC : O(n * k)

    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        int n = arr.length; // number of words in the given list of strings
        
        // key : sorted string
        // value : list of strings,  where each string characters when sorted will make these key
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String str : arr) {
            char[] charray = str.toCharArray();
            Arrays.sort(charray);
            
            String sortedStr = new String(charray);
    
            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            
            map.get(sortedStr).add(str);
        }
    
        // Create a 2D arraylist to return => which includes all anagrams together
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        for(String sortedStr : map.keySet()) {
            ans.add(map.get(sortedStr));
        }
        
        return ans;
    }
    
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends