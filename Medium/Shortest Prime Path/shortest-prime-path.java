//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends

//User function Template for Java

class Solution{
    
    int solve(int num1,int num2){
        //code here
        int[] primes = new int[10000]; // 0 for primes and 1 for non-primes
        
        for(int i=2; i<10000; i++) {
            // 0 for primes
            if(primes[i] == 0) {
                for(int j=i*i; j<10000; j+=i) {
                    primes[j] = 1; // 1 for non-primes
                }
            }
        }
        
        int[] res = new int[10000];
        Arrays.fill(res, -1);
        
        res[num1] = 0; // denotes 0 steps are required to reach num1
        
        Queue<Integer> q = new LinkedList<>();
        q.add(num1);
        
        while(q.size() > 0) {
            int num = q.remove();
            
            for(int i=0; i<4; i++) {
                for(int j=0; j<10; j++) {
                    if(i==0 && j==0) {
                        continue;
                    }
                    
                    String str = Integer.toString(num); 
                    
                    String nstr = str.substring(0, i) + Integer.toString(j) + str.substring(i+1);
                    int next = Integer.valueOf(nstr);
                    
                    if(primes[next]==0 && res[next]==-1) {
                        res[next] = 1 + res[num];
                        q.add(next);
                    }
                }
            }
        }
        
        // res[num2] -> denotes the minimum number of steps that are required to reach num2
        return res[num2]; 
    } 
    
}



//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int num1=Integer.parseInt(input_line[0]);
            int num2=Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.solve(num1,num2));
        }
    }
}
// } Driver Code Ends