//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    long ExtractNumber(String sentence) {
        // code here
        int n = sentence.length();
        
        long ans = -1;
        
        int i=0;
        while(i < n) {
            char currChar = sentence.charAt(i);
            
            if(currChar >= '0' && currChar <= '9') {
                long no = 0;
                boolean nine = false;
                
                while(i<n && sentence.charAt(i) >= '0' && sentence.charAt(i) <= '9') {
                    int val = sentence.charAt(i) - '0';
                    
                    no =  no*10 + val;
                    
                    if(val == 9) {
                        nine = true;
                    }
                    
                    i++;
                }
                
                // if nine == false
                if(!nine) {
                    ans = Math.max(ans, no);
                }
            }
            else {
                i++;
            }
        }
        
        return ans;
    }
    
}


/* 
    long ExtractNumber(String sentence) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(sentence);
        List<String> nums = new ArrayList<>();
        while(matcher.find()){
            nums.add(matcher.group());
        }
        
        long max = Long.MIN_VALUE;
        for(String numStr : nums){
            if(!numStr.contains("9")){
                long num = Long.parseLong(numStr);
                max = Math.max(max, num);
            }
        }        
        return max == Long.MIN_VALUE ? -1 : max;
    }
*/

