//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findClosest(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // Time Complexity:- O(Log(N))
    // Space Complexity:- O(1)

    public static int findClosest(int n, int k, int[] arr) {
        // code here
        int low = 0, high = n-1, mid = 0, mn = Integer.MAX_VALUE, ans = -1;
        
        while(low<=high){
            mid = low + (high - low)/2;
            
            int diff = Math.abs(arr[mid]-k);
            
            if(diff <= mn){
                if(diff == mn) {
                    ans = Math.max(ans,arr[mid]);
                }
                else {
                    ans = arr[mid];
                }
                mn = diff;
            }
            
            if(arr[mid] <= k) {
                low = mid+1;
            }
            else {
                high = mid-1; 
            }
        }
        
        return ans;
    }
    
}
        
