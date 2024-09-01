//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(m + n)
    // SC : O(1)
    
    // Using the technique of "merge sort"
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int m = arr1.size();
        int n = arr2.size();
        
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int ans = 0;
        
        while(i < m && j < n) {
            if(arr1.get(i) < arr2.get(j)) {
                sum1 += arr1.get(i);
                i++;
            }
            else if (arr2.get(j) < arr1.get(i)) {
                sum2 += arr2.get(j);
                j++;
            }
            else {
                ans += Math.max(sum1, sum2) + arr1.get(i);
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
            }
        }
        
        while(i < m) {
            sum1 += arr1.get(i);
            i++;
        }
        
        while(j < n) {
            sum2 += arr2.get(j);
            j++;
        }
        
        ans += Math.max(sum1, sum2);
        
        return ans;
    }
    
}


