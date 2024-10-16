//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {

    // TC : O(n)
    // SC : O(1)
    
    public boolean checkSorted(List<Integer> arr) {
        // code here
        int n = arr.size();
        
        int swapCnt = 0;
        
        for(int i = 0; i < n; ++i){
            if(arr.get(i) == i + 1){ // arr[i] == i+1
                continue;
            }
            
            while(arr.get(i) != i + 1){
                int temp = arr.get(arr.get(i) - 1); // temp = arr[arr[i] - 1]
                arr.set(arr.get(i) - 1, arr.get(i)); // arr[arr[i]-1] = arr[i]
                arr.set(i, temp); // arr[i] = temp
                ++swapCnt;
            }
        }
        
        return swapCnt == 2 || swapCnt == 0;
    }
    
}

