//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // Using the "previous smaller  element" & "next smaller element" 
    
    // TC : O(n)
    // SC : O(n)
    
    // Using stack 
    public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
    
        int[] leftSmaller = new int[n];
        leftSmaller[0] = 0;
        
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        
        for(int i=1; i < n; i++) {
            while(!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            
            leftSmaller[i] = st.isEmpty() ? 0 : st.peek();
            
            st.push(arr[i]);
        }
        
        st.clear();
        
        int[] rightSmaller = new int[n];
        rightSmaller[n-1] = 0;
        
        st.push(arr[n-1]);
        
        for(int i=n-2; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            
            rightSmaller[i] = st.isEmpty() ? 0 : st.peek();
            
            st.push(arr[i]);
        }
        
        int diff = 0;
        for(int i=0; i < n; i++) {
            diff = Math.max(diff, Math.abs(leftSmaller[i] - rightSmaller[i]));
        }
        
        return diff;
    }
    
}

