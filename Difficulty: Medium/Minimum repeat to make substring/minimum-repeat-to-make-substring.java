//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A, B));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n + m) where n is the length of s1 and m is the length of s2
    // SC : O(len(s1)) ~ O(n) for the string builder
    
    static int minRepeats(String s1, String s2) {
        // code here
        // Traverse string s2 & check if any character in s2 is not present in s1
        for(int i=0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            
            if(!s1.contains(String.valueOf(ch))) {
                return -1;
            }
        }
        
        StringBuilder sb = new StringBuilder(s1); // track the concatenated string => initially sb = s1
        
        int cnt = 1; // minimum no.of times string s1 repeated => so that string s2 is contained in string s1
        
        // Keep repeating s1 until the length of sb is at least as long as s2
        while(sb.length() < s2.length()) {
            sb.append(s1);
            cnt++;
        }
        
        // Convert StringBuilder sb to String and check if s2 is a substring
        if(sb.toString().contains(s2)) {
            return cnt;
        }
        
        // Append one more s1 to handle cases where s2 might span over two repetitions of s1
        sb.append(s1);
        cnt++;
        
        // Check again if s2 is now a substring
        if(sb.toString().contains(s2)) {
            return cnt;
        }
        
        // If s2 is still not a substring, return -1
        return -1; // String s2 can never be contained in string s1 => ie. s2 cannot be a substring of s1
    }
    
};


