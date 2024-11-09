//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using Count sort  
    
    // Using Greedy approach
    // In order to get minimum possible sum of two numbers => we need to have those two numbers as smallest as possible
    
    // function to return the minimum possible sum of two numbers formed using the elements of the array
    String minSum(int[] arr) {
        // code here
        // 1. Apply count sort => TC : O(n)
        // since 0 <= arr[i] <= 9 => we will take count[] of size 10
        int[] count = new int[10];
        
        for(int num : arr) {
            count[num]++;
        }
        
        // 2. Make 2 numbers using the elements of the arry
        // such that these numbers are as smallest as possible => in order to get minimum possible sum
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        
        boolean toggle = true; // true => for num1, false => for num2
        
        // Iterate over each digit from 0-9, => and take that digit into numbers if its count > 0 & based on toggle
        for(int dig=0; dig <= 9; dig++) {
            while(count[dig] > 0) {
                if(toggle) {
                    num1.append(dig);
                }
                else {
                    num2.append(dig);
                }
                toggle = !toggle;
                count[dig]--;
            }
        }
        
        // 3. remove leading zeros from above two numbers
        String res1 = removeLeadingZeros(num1.toString());
        String res2 = removeLeadingZeros(num2.toString());
        
        // 4. Add the numbers in above two strings as strings
        return addStrings(res1, res2);
    }
    
    
    // Helper function => to remove leading zeros from string
    private String removeLeadingZeros(String num) {
        int n = num.length();
        
        int i = 0;
        while(i < n && num.charAt(i) == '0') {
            i++;
        }

        return num.substring(i);
    }
    
    
    // Helper function => to add the numbers in two strings as string
    private String addStrings(String num1, String num2) {
        // Iterate over both the strings from back(last)
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        int carry = 0;
        
        StringBuilder res = new StringBuilder();
        
        // Iterate over both strings in backward direction
        // till there are characters left in either of the string or if the carry is 1
        while(i >= 0 || j >= 0 || carry == 1) {
            int dig1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int dig2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            
            int sum = dig1 + dig2 + carry;
            
            res.append(sum % 10);
        
            carry = sum / 10;
            
            i--;
            j--;
        }
        
        return res.reverse().toString();
    }
    
}


