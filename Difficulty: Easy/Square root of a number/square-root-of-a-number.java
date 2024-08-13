//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    
    // TC : O(logn)
    // SC : O(1)
    
    // Using Binary Search on the answers approach
    long floorSqrt(long n) {
        // Your code here
        long low = 1, high = n;
        
        // iBinary search on the answers
        while(low <= high) {
            long mid = low + (high - low)/2;
            
            long val = mid * mid;
            
            if(val <= n) {
                // ans = mid;  // mid can be an answer
                low = mid + 1; // eliminate the left half
            }
            else { // val > n
                high = mid - 1; // eliminate the right half
            }
        }
        
        return high; // ans
    }
    
    
    /*
        // TC : O(sqrt(n))
        // SC : O(1)
        
        long floorSqrt(long n) {
            int ans = 1;
            
            for(int i=1; i <= n; i++) {
                if(i*i <= n) {
                    ans = i;
                }
                else {
                    break;
                }
            }
            
            return ans;
        }
    */
    
}

