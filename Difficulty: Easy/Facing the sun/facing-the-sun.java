//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputStrings = input.split(" ");
            int[] height = new int[inputStrings.length];
            for (int i = 0; i < inputStrings.length; i++) {
                height[i] = Integer.parseInt(inputStrings[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countBuildings(height);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Returns count buildings that can see sunlight
    public int countBuildings(int[] height) {
        // code here
        int cnt = 0; // count the buildings that will see the sunrise
        
        int n = height.length;
        int prev = -1;
        
        for(int i=0; i < n; i++) {
            if(height[i] > prev) {
                cnt++;
                prev = height[i];
            }
        }
        
        return cnt;
    }
    
}

