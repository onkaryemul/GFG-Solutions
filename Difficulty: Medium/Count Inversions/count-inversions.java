//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // Inversion count in an array using Merge sort
    
    // TC : O(n*logn)
    // SC : O(n)
    
    // cnt variable to count the pairs (i, j) such i < j && arr[i] > arr[j]
    private static int cnt;
    
    
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        int n = arr.length;
        
        cnt = 0;
        
        mergeSort(arr, 0, n-1); // modified merge sort
        
        return cnt;
    }
    
    
    // Function to perform merge sort
    private static void mergeSort(int[] arr, int low, int high) {
        // Base case 
        if(low >= high) {
            return;
        }
        
        // low < high
        int mid = low + (high - low)/2;
        
        mergeSort(arr, low, mid); // left half
        
        mergeSort(arr, mid+1, high); // right half
        
        merge(arr, low, mid, high); // merging two sorted halves
    }
    
    
    // Function to perform merging to two sorted halves
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        
        int left = low; // starting index of left half of arr
        int right = mid + 1; // starting index of right half of arr
        
        // Storing elements in the temporary array in a sorted manner
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            else { // arr[left] > arr[right] --> inversion pairs
                temp.add(arr[right]);
                cnt += (mid - left + 1); // update the cnt 
                right++;
            }
        }
        
        // If elements on the left half are still left
        while(left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        
        // If elements on the right half are still left
        while(right <= high) {
            temp.add(arr[right]);
            right++;
        }
        
        // transfering all elements from temporary to arr
        for(int i=low; i <= high; i++) {
            arr[i] = temp.get(i-low);
        }
    }
    
}


