//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            long n = Long.parseLong(br.readLine().trim());

            String ans = new Solution().convertToWords(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(1)
    // SC : O(1)
    
    private final String[] one = {"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ", 
                                  "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};
    
    private final String[] ten = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};
    
    
    String convertToWords(long n) {
        StringBuilder result = new StringBuilder();
        
        result.append(numWords((int)(n / 10000000), "crore "));
        result.append(numWords((int)((n / 100000) % 100), "lakh "));
        result.append(numWords((int)((n / 1000) % 100), "thousand "));
        result.append(numWords((int)((n / 100) % 10), "hundred "));
        
        if (n > 100 && n % 100 > 0) {
            result.append("and ");
        }
        
        result.append(numWords((int)(n % 100), ""));
        
        return result.toString().trim();
    }

    
    private String numWords(int n, String s) {
        StringBuilder result = new StringBuilder();
        
        if (n > 19) {
            result.append(ten[n / 10]).append(one[n % 10]);
        } else {
            result.append(one[n]);
        }
        
        if (n != 0) {
            result.append(s);
        }
        
        return result.toString();
    }
    
    
}

