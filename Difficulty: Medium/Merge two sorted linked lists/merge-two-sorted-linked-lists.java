//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("~");
    }

    // Insert node into the list in a sorted manner
    public static Node insertSorted(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null || head.data >= data) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        while (T-- > 0) {
            Node head1 = null;
            Node head2 = null;

            // Reading first linked list input
            String input1 = sc.nextLine();
            String[] elems1 = input1.split(" ");
            for (String elem : elems1) {
                head1 = insertSorted(head1, Integer.parseInt(elem));
            }

            // Reading second linked list input
            String input2 = sc.nextLine();
            String[] elems2 = input2.split(" ");
            for (String elem : elems2) {
                head2 = insertSorted(head2, Integer.parseInt(elem));
            }

            // Merging sorted linked lists
            Solution obj = new Solution();
            Node mergedHead = obj.sortedMerge(head1, head2);
            printList(mergedHead); // Print the merged sorted list
        }
        sc.close();
    }
}

// } Driver Code Ends


/*
Node is defined as:

class Node {
    int data;
    Node next;
    
    Node(int d) {
       data = d; 
       next = null; 
    }
}
*/


class Solution {
    
    // TC : O(m + n), where m = length of first linked list, n = length of second list
    // SC : O(1)
    
    // Optimal approach => constant space
    
    Node sortedMerge(Node head1, Node head2) {
        // code here
        // Base cases / Edge cases
        if(head1 == null) {
            return head2;
        }
        
        if(head2 == null) {
            return head1;
        }
        
        Node temp1 = head1;
        Node temp2 = head2;
        
        Node temp = new Node(-1); // dummy node
        Node newHead = temp;
        
        // using two-pointers approach => similar to merge method in merge sort
        while(temp1 != null && temp2 != null) {
            if(temp1.data < temp2.data) {
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            
            temp = temp.next;
        }
        
        if(temp1 == null) {
            temp.next = temp2;
        }
        
        if(temp2 == null) {
            temp.next = temp1;
        }
        
        return newHead.next;
    }
    
}


