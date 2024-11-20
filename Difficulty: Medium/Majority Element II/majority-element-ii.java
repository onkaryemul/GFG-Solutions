//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
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
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here
        int n = nums.length; // total no. of votes
        
        int num1 = -1;
        int num2 = -1;
        
        int f1 = 0;
        int f2 = 0;
        
        for(int num : nums) {
            if(num == num1) {
                f1++;
            }
            else if(num == num2) {
                f2++;
            }
            else if(f1 == 0) {
                num1 = num;
                f1++;
            }
            else if(f2 == 0) {
                num2 = num;
                f2++;
            }
            else {
                f1--;
                f2--;
            }
        }
        
        f1 = 0;
        f2 = 0;
        
        for(int num : nums) {
            if(num == num1) {
                f1++;
            }
            else if(num == num2) {
                f2++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        if(f1 > n/3) {
            res.add(num1);
        }
        
        if(f2 > n/3) {
            res.add(num2);
        }
        
        if(res.size() == 2) {
            if(res.get(0) > res.get(1)) {
                int temp = res.get(0);
                res.set(0, res.get(1));
                res.set(1, temp);
            }
        }
        
        return res;
    }
    
}

