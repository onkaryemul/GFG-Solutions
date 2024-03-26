//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ss = new Solution();
            boolean result = ss.isAdditiveSequence(s);
            System.out.println((result == true ? 1 : 0));
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n^3)
    // SC : O(n)
    public boolean isAdditiveSequence(String num) {
        // code here
        int n = num.length();
        
        if(n < 3) {
            return false;
        }
        
        
        for(int i = 1; i <= n/2; i++) {
            for(int j = 1; Math.max(i,j) <= n-i-j; j++) {
                String first = num.substring(0, i);
                String second = num.substring(i, i+j);
                
                if(first.length() > 1 && first.charAt(0) == '0') {
                    break;
                }
                
                if(second.length() > 1 && second.charAt(0) == '0') {
                    break;
                }
                
                int start = i+j;
                String sum;
                
                while(start < n) {
                    sum = addStrings(first, second);
                    
                    if(start + sum.length() > n || !sum.equals(num.substring(start, start+sum.length()))) {
                        break;
                    }
                    
                    first = second;
                    second = sum;
                    start += sum.length();
                }
                
                if(start == n) {
                    return true;
                }
            }
        }
        
        
        return false;
    }
    
    
    private String addStrings(String num1, String num2) {
        
        StringBuilder res = new StringBuilder();
        int carry = 0;
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        while(i >= 0 || j >= 0 || carry != 0) {
            int x = carry;
            
            if(i >= 0) {
                x += num1.charAt(i--) - '0';
            }
            
            if(j >= 0) {
                x += num2.charAt(j--) - '0';
            }
            
            carry = x / 10;
            x %= 10;
            
            res.insert(0, x);
        }
        
        return res.toString();
    }
    
}

