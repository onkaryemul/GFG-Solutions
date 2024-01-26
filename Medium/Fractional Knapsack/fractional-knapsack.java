//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


// Custom comparator for custom sorting
class ItemComparator implements Comparator<Item> {
    public int compare(Item a, Item b) {
        double r1 = (double)a.value / a.weight; // per unit weight value of Item a
        double r2 = (double)b.value / b.weight; // per unit weight value of Item b
        
        if(r1 > r2) {
            return -1;
        } 
        else if (r1 < r2) {
            return 1;
        }
        
        return 0;
    }
}



class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr, new ItemComparator());
        
        int currWeight = 0;
        
        double finalValue = 0.0;
        
        
        for(int i=0; i<n; i++) {
            if(currWeight + arr[i].weight <= W) {
                currWeight += arr[i].weight;
                finalValue += arr[i].value;
            }
            else {
                int remain = W - currWeight;
                finalValue += arr[i].value * ((double)remain / arr[i].weight);
                break;
            }
        }
        
        
        return finalValue;
    }
    
}
