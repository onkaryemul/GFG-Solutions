//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    
    // TC : O(N*logN) + O(M*logN) ~ O((N+M)*logM)
    // SC : O(1)
    
    // Using sorting + Binary search
    
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int arr[], int brr[], int M, int N) {
        // code here
        // Sort the brr[] ->  O(N*logN)
        Arrays.sort(brr); 
        
        long pairsCnt = 0; 
        long one = 0, two = 0, threeFour = 0;
        
        // Iterate through brr[] -> O(N)
        for(int x : brr) {
            if(x == 1) {
                one++;
            }
            else if (x == 2) {
                two++;
            }
            else if (x == 3 || x == 4) {
                threeFour++;
            }
        }
        
        // Iterate through arr[] -> O(M)   ---> Overall O(M * logN)
        for(int x : arr) {
            if(x != 1) {
                pairsCnt += one; // adding the pairs with 1 in the brr[]
                
                if(x == 2) {
                    pairsCnt -= threeFour; // reducing the pairsCnt that we formed with 2 in arr[] & 3 or 4 in brr[]
                }
                
                if(x == 3) {
                    pairsCnt += two; // adding the pairs that were formed with 3 in arr[] & 2 in brr[]
                }
                
                int index = binarySearch(brr, x); // O(logN)
                
                pairsCnt += (brr.length - index - 1);
            }
        }
        
        return pairsCnt;
    }
    
    
    // apply binary search on brr[]
    // return the index --> from which onwards all elements > key
    private int binarySearch(int[] brr, int key) {
        int index = -1;
        
        int low = 0;
        int high = brr.length - 1;
        
        int mid;
        
        while(low <= high) {
            mid = low + (high - low)/2;
            
            if(brr[mid] <= key) {
                index = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
    
        return index;
    }
    
}


