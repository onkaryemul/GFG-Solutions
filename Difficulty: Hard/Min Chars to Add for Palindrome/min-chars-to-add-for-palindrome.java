//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    public static int minChar(String s) {
        //Write your code here
        StringBuilder res = new StringBuilder(s);
       
        String rev = res.reverse().toString();
        
        res.reverse().append("$").append(rev);
      
        int lps[] = LPS(res.toString());
        
        return s.length() - lps[res.length() - 1];
    }
   
    
    // Helper function ==> longest Proper Prefix Suffix
    private static  int[] LPS(String str) {
	    int n = str.length();
	    
	    int lps[] = new int[n];
	    lps[0] = 0; // lps[0] is always 0
	     
        int i = 1, len = 0;
        	     
	    while (i < n) {
	        if (str.charAt(i) == str.charAt(len)) {
	            len++;
	            lps[i] = len;
	            i++;
	        }
	        else {
	            if (len == 0) {
	                lps[i] = 0;
	                i++;
	            }
	            else {
	                len = lps[len - 1];
	            }
	        }
	    }
	    
	    return lps;
	}
    
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));

            System.out.println("~");
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private void read() throws IOException {
            st = new StringTokenizer(br.readLine());
        }

        public String nextString() throws IOException {
            while (!st.hasMoreTokens()) read();
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }
    }
}
// } Driver Code Ends