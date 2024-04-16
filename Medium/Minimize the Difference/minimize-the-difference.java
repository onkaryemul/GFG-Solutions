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
            int res = obj.minimizeDifference(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public static int minimizeDifference(int n, int k, int[] arr) {
        // code here
        // Step 1:
        int[] rmax = new int[n];
        rmax[n-1] = arr[n-1];
        
        int[] rmin = new int[n];
        rmin[n-1] = arr[n-1];
        
        for(int i=n-2; i >= 0; i--) {
            rmax[i] = Math.max(arr[i], rmax[i+1]);
            rmin[i] = Math.min(arr[i], rmin[i+1]);
        }
        
        // Step 2: 1st window
        int ans = rmax[k] - rmin[k];
        
        // Step 3: Handling second window onwards till second last window
        int lmax = arr[0];
        int lmin = arr[0];
        
        // for each i, removing k element starting from i
        for(int i=1; i < n-k; i++) {
            int maxInRemaining = Math.max(lmax, rmax[i+k]);
            int minInRemaining = Math.min(lmin, rmin[i+k]);
            
            int currDiff = maxInRemaining - minInRemaining;
            
            ans = Math.min(ans, currDiff);
            
            // update the lmax and lmin for next itr
            lmax = Math.max(arr[i], lmax);
            lmin = Math.min(arr[i], lmin);
        }
        
        // Step 4: last window
        ans = Math.min(ans, lmax-lmin);
        
        return ans;
    }
    
}
        


