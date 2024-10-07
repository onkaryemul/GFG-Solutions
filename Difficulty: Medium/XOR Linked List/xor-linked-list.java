//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        Solution soln = new Solution();
        while (t-- > 0) {
            Node head = null;
            String input = scanner.nextLine();
            Scanner ss = new Scanner(input);
            List<Integer> arr = new ArrayList<>();
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }
            int n = arr.size();
            for (int i = 0; i < n; i++) {
                int tmp = arr.get(i);
                head = soln.insert(head, tmp);
            }

            ArrayList<Integer> list = soln.getList(head);
            for (int x : list) System.out.print(x + " ");
            System.out.println();

            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}

class Node {
    int data;
    Node npx;

    Node(int x) {
        data = x;
        npx = null;
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node npx;

    Node(int x) {
        data = x;
        npx = null;
    }
}
*/


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // XOR Linked List
    
    // (prev ^ next) ==> npx
    
    // (prev ^ next) ^ prev = next
    // npx ^ prev = next
    
    // (prev ^ next) ^ next = prev
    // npx ^ next = prev
    
    
    // function should insert the data to the front of the list
    static Node insert(Node head, int data) {
        // Code Here
        Node newNode = new Node(data);
        newNode.npx = head;
        return newNode;
    }

    // function to print the linked list
    static ArrayList<Integer> getList(Node head) {
        // Code Here
        ArrayList<Integer> list = new ArrayList<>();
        
        Node curr = head;
        while(curr != null) {
            list.add(curr.data);
            curr = curr.npx;
        }
        
        return list;
    }
    
}

