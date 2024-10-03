//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Moore's Voting Algorithm
    
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here
        int n = nums.size();
        
        // there can be at most 2 majority elements having votes > n/3
        int ele1 = Integer.MAX_VALUE;;
        int cnt1 = 0;
        
        int ele2 = Integer.MAX_VALUE;;
        int cnt2 = 0;
        
        for(int i=0; i < n; i++) {
            if(nums.get(i) == ele1) {
                cnt1++;
            }
            else if(nums.get(i) == ele2) {
                cnt2++;
            }
            else if(cnt1 == 0) {
                ele1 = nums.get(i);
                cnt1++;
            }
            else if(cnt2 == 0) {
                ele2 = nums.get(i);
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        
        
        List<Integer> result = new ArrayList<>();
        
        int freq1 = 0, freq2 = 0;
        
        for(int i=0; i < n; i++) {
            if(nums.get(i) == ele1) {
                freq1++;
            } 
            
            if(nums.get(i) == ele2) {
                freq2++;
            }
        }
        
        
        if(freq1 > n/3) {
            result.add(ele1);
        }
        
        if(freq2 > n/3) {
            result.add(ele2);
        }
        
        if(result.size() == 0) {
            result.add(-1);
        }
        
        return result;
    }
    
}

