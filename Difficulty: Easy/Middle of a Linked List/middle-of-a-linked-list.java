//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution g = new Solution();
            int ans = g.getMiddle(head);
            System.out.println(ans);
            // printList(head);
            t--;
        }
    }
}

// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // One-pass solution
    
    // Using Hare and Tortoise algorithm
    // Slow & fast pointer approach
    int getMiddle(Node head) {
        // Your code here
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
    
}


/* 
    // TC : O(n)
    // SC : O(1)
    
    // Two-pass solution
    
    // Middle node of linked list ->  (Length Of Linked List / 2)  + 1;
    
    int getMiddle(Node head) {
        // Your code here
        int len = 0;
        
        Node temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        
        temp = head;
        
        int mid = (len / 2) + 1;
        
        while(temp != null) {
            mid--;
            
            if(mid == 0) {
                return temp.data;
            }
            
            temp = temp.next;
        }
        
        return -1;
    }
*/


