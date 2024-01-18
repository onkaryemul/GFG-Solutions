//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        // code here
        List<Pair> sprinklers = new ArrayList<>();
        
        // Loop through the gallery array
        for(int i=0; i<n; i++) {
            // Check if the gallery is not blocked
            if(gallery[i] != -1) {
                // Add the sprinkler coordinate range to the list
                sprinklers.add(new Pair(i-gallery[i], i+gallery[i]));
            }
        }
        
        // Sort the sprinklers list based on the starting coordinate
        Collections.sort(sprinklers, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.x - p2.x;
            }
        });
        
        
        int sprinklersOn = 0;
        int target = 0;
        int i = 0;
        
        // Iterate until target reaches the end of the gallery
        while(target < n) 
        {
            // Check if there are no more sprinklers or the next sprinkle is beyond the target coordinate
            if(i==sprinklers.size() || sprinklers.get(i).x > target) {
                // return -1 indicating no solution
                return -1;
            }
            
            int maxRange = sprinklers.get(i).y;
            
            // Check if there are more sprinklers within the range of the target coordinate
            while(i+1 < sprinklers.size() && sprinklers.get(i+1).x <= target) 
            {
                i++;
                // Update the maximum range
                maxRange = Math.max(maxRange, sprinklers.get(i).y);
            }
            
            // Check if the maximum range is less than the target coordinate
            if(maxRange < target) {
                // return -1 indicating no solution
                return -1;
            }
            
            // Increment the number of sprinklers turned on
            sprinklersOn++;
            
            // Update the target coordinate to the maximum range plus one
            target = maxRange + 1;
            
            // Move to the next sprinkler
            i++;
        }
        
        // Return the total number of sprinklers turned on
        return sprinklersOn;
    }
    
}
