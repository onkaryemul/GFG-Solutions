//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


/*
class Job {
    int id, profit, deadline;
    
    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/


class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    
    // Greedy Approach - Performing those jobs first which have maximum profit at their end days
    
    
    //Function to find the maximum profit and the number of jobs done
    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        int[] ans = new int[2];
        // having 0th element equal to the count of jobs done
        // & 1st element equal to the maximum profit received
        
        // 1. Sort the given jobs array arr in descending order their profit
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        
        // 2. Get the which is the maxdeadline from the jobs array
        int maxDeadline = 0; 
        for(int i=0; i < n; i++) {
            if(arr[i].deadline > maxDeadline) {
                maxDeadline = arr[i].deadline;
            }
        }
        
        // 3. Create jobSeq array of size (maxDeadline + 1) to store which jobs are performed at ith unit of time
        int[] jobSeq = new int[maxDeadline + 1];
        for(int i=1; i <= maxDeadline; i++) {
            jobSeq[i] = -1;
        }
        
        // 4. Calculate no. of jobs that are performed within their deadline and total profit achieved after doing them
        int cntJobs = 0;
        int totalProfit = 0;
        
        // traverse through jobs array which are now in descending order of their profit
        for(int i=0; i < n; i++) {
            // Check for current job deadline ie. jobs arr[i].deadline, whether that can performed at the end day of its deadline or before it
            // Find free slot starting from current job deadline to initial or 1st deadline
            for(int j=arr[i].deadline; j > 0; j--) {
                // Check if it is free slot
                if(jobSeq[j] == -1) { 
                    // free slot found
                    jobSeq[j] = i; // performe ith job at the jth deadline unit
                    cntJobs++; 
                    totalProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        ans[0] = cntJobs;
        ans[1] = totalProfit;
        
        return ans;  // return an array of size 2 
    }
    
}

