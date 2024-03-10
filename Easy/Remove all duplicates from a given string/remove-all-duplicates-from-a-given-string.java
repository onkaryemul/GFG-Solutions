//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    String removeDuplicates(String str) {
        int[] smallCaseAsc = new int[26];
        int[] bigCaseAsc = new int[26];
         
        StringBuilder sb = new StringBuilder();
        
        for(char ch : str.toCharArray()) {
            if(ch >= 97 && ch <= 122) {
                if(smallCaseAsc[ch - 'a'] == 0) {
                    sb.append(ch);
                    smallCaseAsc[ch - 'a']++;
                }
            }
            else {
                if(bigCaseAsc[ch - 'A'] == 0) {
                    sb.append(ch);
                    bigCaseAsc[ch - 'A']++;
                }
            }
        }
        
        return sb.toString();
    }
    
}

