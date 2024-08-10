//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends


//User function Template for Java
class Solution{
    
    // TC : O(n*logn)
    // SC : O(1), not considering answer arraylist which we have to return
    
    // Greedy approach & two pointers technique
    
    // Function for finding maximum and value pair
    public static ArrayList<Integer> RopeCutting (int arr[], int n) {
        // Complete the Function
        // 1. Sort the given array arr
        Arrays.sort(arr);
    
        ArrayList<Integer> list = new ArrayList<>();
        
        int curr = 0;
        int j = 1;
        
        while(j < n) {
            if(arr[j] - arr[curr] > 0) {
                list.add(n-j);
                curr = j;
            }
            j++;
        }
        
        return list;
    }
 
}



//{ Driver Code Starts.
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] =  Integer.parseInt(elements[i]);
		    }
		    
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res;
		    res = obj.RopeCutting(arr, sizeOfArray);
		    for(int i: res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            


// } Driver Code Ends