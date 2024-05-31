//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    static int swapNibbles(int n) {
        // code here
        // Isolate the right nibble (lower 4 bits)
        int rn = n & 0b11110000;
        // Isolate the left nibble (upper 4 bits)
        int ln = n & 0b00001111;
        
        // shift the right nibble to the left by 4 bits
        rn = rn >> 4;
        // Shift the left nibble to the right by 4 bits
        ln = ln << 4;
        
        // combine the two nibbles
        return rn | ln;
    }
    
}

