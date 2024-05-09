//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            String ans = obj.divisorGame(n) ? "True" : "False";
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    // Time Complexity:- O(1)
    // Space Complexity:- O(1)

    public static boolean divisorGame(int n) {
        // code here
        
        // If n is even, Alice can always choose x = 1, which makes Bob get an odd number.
        // In the next turn, Bob can only choose an odd divisor of an odd number, which makes the number even again.
        // Since Alice starts first and gets an even number in each turn, she wins.
        
        // If n is odd, Alice can only choose an odd divisor, which results in an even number for Bob.
        // Bob will then be in the same position as Alice was in the previous turn.
        // Eventually, Alice will end up with 1, and Bob will wins the game.
        
        // Thus, if n is even, Alice wins; otherwise, Bob wins.
        return n % 2 == 0;
    }
    
}

