//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static String oddEven(String s) {
        // code here
        int x = 0, y = 0;
        int len = s.length();
        
        int[] count = new int[27];
        // Count the frrequency of each character in the string
        for(int i=0; i < len; i++) {
            count[s.charAt(i) - 'a' + 1]++;
        }
        
        // Iterate through the counts to determine x and y
        for(int i=1; i <= 26; i++) {
            if(count[i] != 0 && count[i]%2==0 && i%2==0) {
                x++;
            }
            else if (count[i]%2==1 && i%2==1) {
                y++;
            }
        }
        
        // Calculate the sum and determine if it is ODD or EVEN
        int sum = x + y;
        
        return sum%2 == 0 ? "EVEN" : "ODD";
    }
    
}

