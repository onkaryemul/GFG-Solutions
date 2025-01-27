//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

// class LRUCache {
    
//     // Constructor for initializing the cache capacity with the given value.
//     LRUCache(int cap) {
//         // code here
//     }

//     // Function to return value corresponding to the key.
//     public static int get(int key) {
//         // your code here
//     }

//     // Function for storing key-value pair.
//     public static void put(int key, int value) {
//         // your code here
//     }
// }


class LRUCache {

    static Map<Integer, Integer> cache;
    static int capacity;
    
    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        // code here
        cache = new LinkedHashMap();
        capacity = cap;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        // your code here
        if(!cache.containsKey(key)){
            return -1;
        }
        
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
        
        return val;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        // your code here
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key, value);
            
            return;
        }
        
        if(cache.size() == capacity){
            int rem = -1;
            
            for(int i: cache.keySet()){
                rem = i;
                break;
            }
            
            cache.remove(rem);
        }
        
        cache.put(key, value);
    }
    
}


