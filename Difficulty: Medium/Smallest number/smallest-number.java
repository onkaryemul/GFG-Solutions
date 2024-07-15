//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(d)
    // SC : O(d) ~ O(6) ~ O(1)
    
    public String smallestNumber(int s, int d) {
        // code here
        // Base case
        if(s > 9*d) {
            return "-1";
        }
        
        int[] arr = new int[d];
        arr[0] = 1;
        
        s--;
        
        for(int i=d-1; i>=0 && s>0; i--) {
            if(s > 9) {
                s -= 9;
                arr[i] = 9;
            }
            else {
                arr[i] += s;
                s = 0;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i : arr) {
            sb.append(i);
        }
        
        return sb.toString();
    }
    
}

