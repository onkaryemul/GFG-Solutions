//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    // TC : O(n)
    // SC : O(n)
    
    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        int tn = txt.length(), pn = pat.length();
        int lps[] = new int[pn];
        fill(pat,lps,pn);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i=0, j=0;
        
        while(j<tn){
            if(pat.charAt(i)==txt.charAt(j)){
                i++;
                j++;
            }else{
                if(i==0)    j++;
                else    i=lps[i-1];
            }
            
            if(i==pn){
                ans.add(j-pn);
                i=lps[i-1];
            }
        }
        
        return ans;
    }
    
    
    void fill(String s,int a[],int n){
        int i=0, j=1;
        while(j<n){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                a[j]=i;
                j++;
            }else{
                if(i==0)    j++;
                else    i=a[i-1];
            }
        }
    }
    
}


