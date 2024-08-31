//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


/*Complete the function below*/
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using the concept of "previous-smaller-element" & "next-greater-element" --> Using stack
    
    // Function to find three numbers such that arr[smaller[i]] < arr[i] < arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        // code here
        int n = arr.length;
        
        List<Integer> ans = new ArrayList<>();
        
        Stack<Integer> st = new Stack<>(); // for finding out "previous-smaller-element" & "next-greater-element"
        int[] leftSmaller = new int[n];
        int[] rightGreater = new int[n];
        
        // traverse arr[] and poplulate "previous-smaller-element" for every element of arr[]
        // traverse left to right
        for(int i=0; i < n; i++) {
            while(!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            
            leftSmaller[i] = st.isEmpty() ? -1 : st.peek();
            
            st.push(arr[i]);
        }
        
        // clear the stack st
        while(!st.isEmpty()) {
            st.pop();
        }
        
        // traverse arr[] and populate "next-greater-element" for every element of arr[]
        // traverse right to left
        for(int i=n-1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            
            rightGreater[i] = st.isEmpty() ? -1 : st.peek();
            
            st.push(arr[i]);
        }
        
        // traverse the leftSmaller[] and rightGreater[]
        for(int i=0; i < n; i++) {
            // If any of the them is not present, then continue
            if(leftSmaller[i] == -1 || rightGreater[i] == -1) {
                continue;
            }
            
            ans.add(leftSmaller[i]); // left-smaller
            ans.add(arr[i]); // current
            ans.add(rightGreater[i]); // right greater
            
            break;
        }
        
        
        return ans;
    }
    
}


