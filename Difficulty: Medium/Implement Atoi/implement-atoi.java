//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public int myAtoi(String s) {
        // Your code here
        int n = s.length();
        
        int i = 0;
        while(i < n && s.charAt(i) == ' '){
            ++i;
        }
        
        int sign = 1;
        
        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+' )){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            ++i;
        }
        
        long res = 0;
        
        while(i < n && Character.isDigit(s.charAt(i))){
            res = res * 10 + s.charAt(i) - '0';
            
            if(res * sign > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            
            if(res * sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            
            ++i;
        }
        
        return (int)(res * sign);
    }

}

