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

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Reverse + Add + Reverse
    public Node addOne(Node head) {
        // code here
        // 1. Reverse the given linked list
        head = reverse(head);
        
        // 2. Add 1 to the linked list
        int carry = 1; // adding 1 to the linked list
        
        Node curr = head;
        while(curr != null) {
            int val = curr.data + carry;
            
            curr.data = val%10;
            carry = val/10;
            
            // Edge case/Corner case
            // Check if it is last node
            if(curr.next == null) {
                break;
            }
            
            curr = curr.next;
        }
        
        // Check if carry is non-zero
        if(carry != 0) { // if yes, then add new node with val carry & attach to last node next
            curr.next = new Node(carry);
        }
        
        // 3. Again, reverse it
        head = reverse(head);
        
        return head;
    }
    
    
    // Function to reverse the given linked list
    private Node reverse(Node head) {
        Node prev = null, curr = head, next;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
}

