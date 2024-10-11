//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Changed to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution ob = new Solution();
            Vector<Integer> result = ob.addOne(arr);

            // Print the result vector
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(1), not including the result list(vector) that we have to return
    
    // Function for adding one to the number represented by the array
    Vector<Integer> addOne(int[] arr) {
        // code here
        int n = arr.length;
        
        Vector<Integer> ans = new Vector<Integer>();
        
        int carry = 1; // we want to add 1 to the given number (represented as an array of digits)
        
        int sum = 0;
        
        for(int i=n-1; i >= 0; i--) {
            sum = arr[i] + carry;
            
            int rem = sum % 10;
            
            ans.add(rem);
            
            carry = sum / 10;
        }
        
        if(carry > 0) {
            ans.add(carry);
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
    
}


