//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n^2)
    // SC : O(1)
    
    // Using 2 pointers approach ==> to find pair of elements whose sum equals target
    
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int n = arr.length;
        
        int cnt = 0;
        
        for(int i=0; i <= n-3; i++) {
            // using 2-pointers approach
            int j = i+1;
            int k = n-1;
            
            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                
                if(sum > target) {
                    k--;
                }
                else if(sum < target) {
                    j++;
                }
                else if(sum == target) {
                    cnt++; // found a triplet
                    
                    int temp = j + 1;
                    
                    while(temp < k && arr[temp] == arr[temp-1]) {
                        cnt++; // duplicate elements can also make a triplet
                        temp++;
                    }
                    
                    k--;
                }
            }
        }
        
        return cnt;
    }
    
}

