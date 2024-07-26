//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
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
class Solution
{
    // TC : O(logn)
    // SC : O(1)
    
    // Binary Search on answers
    long floorSqrt(long x) {
		// Your code here
		long low = 1, high = x;
		
		// Binary search on the answers
		while(low <= high) {
		    long mid = low + (high - low)/2;
		    
		    long val = mid * mid;
		    
		    if(val <= x) {
		        low = mid + 1; // eliminate the left half
		    }
		    else {
		        high = mid - 1; // eliminate the right half
		    }
		}
		
	    return high; 
	}
	 
}

