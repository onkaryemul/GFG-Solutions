//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public List<Integer> rearrange(List<Integer> arr) {
        // Code here
        int n = arr.size();
        
        List<Integer> temp = new ArrayList<>();
        // Initialize the temp list with -1
        for(int i=0; i < n; i++) {
            temp.add(-1);
        }
        
        for(int i=0; i < n; i++) {
            if(arr.get(i) == -1) {
                continue;
            }
            else {
                // temp[arr[i]] = arr[i]
                temp.set(arr.get(i), arr.get(i));
            }
        }
        
        return temp;
    }
    
}



//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Solution solution = new Solution();

        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            List<Integer> arr = new ArrayList<>();
            for (String s : inputArr) {
                arr.add(Integer.parseInt(s));
            }

            List<Integer> ans = solution.rearrange(arr);

            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
// } Driver Code Ends