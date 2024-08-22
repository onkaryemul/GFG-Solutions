//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   
    public String findOrder(String [] dict, int N, int K){
        // Write your code here
        Map<Character,List<Character>> map = new HashMap<>();
        for(String word : dict){
            for(char c : word.toCharArray()){
                map.put(c, new ArrayList<>());
            }
        }
        
        
        for(int i=1; i<N; i++){
            for(int j=0; j < Math.min(dict[i-1].length(), dict[i].length()); j++){
                if(dict[i-1].charAt(j) != dict[i].charAt(j)) {
                    map.get(dict[i-1].charAt(j)).add(dict[i].charAt(j));
                    break;
                }
            }
        }
        
        Set<Character> vis = new HashSet<>();
        Stack<Character> st = new Stack<>();
        
        for(Character k : map.keySet()){
            if(!vis.contains(k)) {
                topologicalSort(map, st, vis, k);
            }
        }
        
        String ans = "";
        while(!st.isEmpty()){
            ans += st.pop();
        }
        
        return ans;
    }
    
    
    private void topologicalSort(Map<Character,List<Character>> map, Stack<Character> st, Set<Character> vis, char c){
        vis.add(c);
        
        for(Character nbr : map.get(c)){
            if(!vis.contains(nbr)) {
                topologicalSort(map,st,vis,nbr);
            }
        }
        
        st.push(c);
    }
    
}

