//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
    class Node
    {
        int data;
        Node next, prev;
        Node(int data)
        {
            this.data = data;
            next = prev = null;
        }
    }
*/


class Solution {
    
    // TC : O(n*logn)
    // SC : O(logn) 
    
    
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        // Base case
        if(head == null || head.next == null) { // empty or one node
            return head;
        }
        
        // split in two halves recursively
        Node h2 = funcSplit(head);
        
        head = sortDoubly(head);
        h2 = sortDoubly(h2);
        
        return merge(head, h2);
    }
    
    
    private static Node funcSplit(Node head) {
        Node slow = head;
        Node fast = head;
        
        while(fast.next != null && fast.next.next != null) { // odd and even case
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node temp = slow.next;
        slow.next = null;
        
        return temp;
    }
    
    
    private static Node merge(Node h1, Node h2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        
        while(h1!=null && h2!=null) { // till both list exist
            if(h1.data < h2.data) {
                curr.next = h1;
                h1.prev = curr;
                
                h1 = h1.next;
            }
            else {
                curr.next = h2;
                h2.prev = curr;
                
                h2 = h2.next;
            }
            
            curr = curr.next;
        }
        
        // iterating in remaining ele in h1 list
        if(h1 != null) {
            curr.next = h1;
            h1.prev = curr;
        }
        
        // iterating in remaining ele in h2 list
        if(h2 != null) {
            curr.next = h2;
            h2.prev = curr;
        }
        
        Node ans = dummy.next;
        ans.prev = null;
        
        return ans;
    }
    
}

