//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n^2)
    // SC : O(n^2)
    
    // Optimal approach
    
    // triplets sum must be zero
    
    // arr[i] + arr[j] + arr[k] = 0
    // arr[i] + arr[j] = - arr[k]
    
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        int n = arr.length;
        
        // key : arr[i] + arr[j]
        // value : List of {i, j} where i < j for given arr[i] + arr[j]
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        
        for(int i=0; i < n-1; i++) {
            for(int j=i+1; j < n; j++) {
                int sum = arr[i] + arr[j];
                
                if(!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                
                map.get(sum).add(new int[]{i, j});
            }
        }
        
        //  Set ==> to store unique triplets
        Set<List<Integer>> resSet = new HashSet<>();
        
        for(int k=0; k < n; k++) {
            int rem = - arr[k];
            
            if(map.containsKey(rem)) {
                List<int[]> pairs = map.get(rem);
                
                for(int[] p : pairs) {
                    if(p[0] != k && p[1] != k) {
                        List<Integer> curr = Arrays.asList(p[0], p[1], k);
                        Collections.sort(curr);
                        resSet.add(curr);
                    } 
                }
            }
        }
        
        return new ArrayList<>(resSet);
    }
    
}




//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends