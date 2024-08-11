//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(N)
    // SC : O(N)
    
    // Using stack
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i < N; i++) {
            if(st.isEmpty() || asteroids[i] > 0) {
                st.add(asteroids[i]);
            }
            else if (asteroids[i] < 0 && st.peek() < 0) {
                st.add(asteroids[i]);
            }
            else {
                boolean isSame = false;
                
                while(!st.isEmpty()) {
                    // stack is larger
                    if(st.peek() < 0 && asteroids[i] < 0) {
                        st.add(asteroids[i]);
                        break;
                    }
                    
                    if(st.peek() > Math.abs(asteroids[i])) {
                        break;
                    }
                    else if(st.peek() < Math.abs(asteroids[i])) { // asteroids[i] is larger
                        st.pop();
                    }
                    else if(st.peek() == Math.abs(asteroids[i])) { // both are same
                        st.pop();
                        isSame = true;
                        break;
                    }
                }
                
                if(st.isEmpty() && isSame == false) {
                    st.add(asteroids[i]);
                }
            }
        }
        
        int[] ans = new int[st.size()];
        for(int i=ans.length-1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        
        return ans;
    }
    
}

