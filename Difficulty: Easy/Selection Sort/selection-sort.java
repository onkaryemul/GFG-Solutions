//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends



class Solution {
    
    // TC : O(n^2)
    // SC : O(1)
    
    // Selection sort
    // Select Minimums (at the front) and swap
    
    void selectionSort(int arr[], int n) {
	    //code here
	    // Iterate through arr[] from index 0 to n-2
	    // sorted subarray.....unsorted subarray
	    for(int i=0; i <= n-2; i++) {
	        int mini = select(arr, i);
	        if(mini != i) {
	            int temp = arr[mini];
	            arr[mini] = arr[i];
	            arr[i] = temp;
	        }
	    }
	    
	}
	
	
	// select() --> takes arr[] & starting point of unsorted array(i) as parameters
	// returns the selected element (index) for each iteration of selection sort
	int  select(int arr[], int i) {
        // code here such that selectionSort() sorts arr[]
        int n = arr.length;
        
        int mini = i; // index of minimum element in arr[] starting from i
        
        for(int j=i; j <= n-1; j++) {
            if(arr[j] < arr[mini]) {
                mini = j;
            }
        }
        
        return mini;
	}
	
}


/* 
    // Select Minimums & swap
    
    static void selection_sort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int mini = i;
            
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            
            //swap
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }
*/


