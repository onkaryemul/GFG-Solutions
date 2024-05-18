//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int findPeakElement(List<Integer> a) {
        // Code here
        int low = 0;
        int high = a.size() - 1;
        
        // Binary search to find peak element
        while(low < high) {
            int mid = low + (high - low)/2; // calculate the mid index
            
            if(a.get(mid) > a.get(mid+1)) {
                high = mid;
            }
            else { // a.get(mid) < a.get(mid+1)
                low = mid + 1;
            }
        } 
        
        return a.get(low);
    }
    
}

