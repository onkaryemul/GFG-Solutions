//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public long findMaxProduct(List<Integer> arr) {
        // code here
        int n = arr.size();
        
        int negCnt = 0, zeroCnt = 0;
        int maxNegative = Integer.MIN_VALUE;
        
        int mod = 1000000007;
        long prod = 1;
        
        for(int i=0; i < n; i++) {
            int currNum =  arr.get(i);
            
            if(currNum == 0) {
                zeroCnt++;
            }
            else if (currNum < 0) {
                negCnt++;
                maxNegative = Math.max(maxNegative, currNum);
                prod *= currNum;
            }
            else {
                prod *= currNum;
            }
            
            prod %= mod;
        }
        
        // Check for below cases
        
        // 1st case: all are zero, then return 0
        if(zeroCnt == n) {
            return 0;
        }
        
        // 2nd case: only 1 negative and all rest are zero, then return 0
        if(negCnt == 1 && zeroCnt == n-1) {
            return 0;
        }
        
        // 3rd case: Even no. of negative numbers, then simply return product
        if(negCnt % 2 == 0) {
            return prod;
        }
        
        // else, odd no. of negative numbers, then divide product by maxNegative
        return prod / maxNegative;
    }
    
}


