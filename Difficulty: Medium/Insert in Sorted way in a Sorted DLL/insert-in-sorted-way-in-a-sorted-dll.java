//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline character after t

        while (t-- > 0) {
            String input = sc.nextLine(); // Read the entire line for the array elements
            String[] values = input.split(" ");

            Node head = null, tail = null;
            for (String value : values) {
                int x = Integer.parseInt(value);
                if (head == null) {
                    head = new Node(x);
                    tail = head;
                } else {
                    tail.next = new Node(x);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
            }

            int valueToInsert = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine(); // Ignore the newline character after the value
            }

            Solution obj = new Solution();
            head = obj.sortedInsert(head, valueToInsert);
            printList(head);
        
System.out.println("~");
}

        sc.close();
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
class of the node of the DLL is as

class Node {
    int data;
    Node prev, next;
    
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public Node sortedInsert(Node head, int x) {
        // add your code here
        // Case 1 : If given DLL is empty
        if(head == null) {
            Node newHead = new Node(x);
            return newHead;
        }
        
        // Case 2 : If head.data > x.data => means node(x) should become new head
        if(head.data > x) {
            Node newHead = new Node(x);
            newHead.next = head;
            head.prev = newHead;
            
            head = newHead;
            
            return head;
        }
        
        // Cases 3 : If node(x) should be somewhere in between sorted DLL
        Node temp = new Node(x);
        
        Node prev = null;
        Node curr = head;
        
        while(curr != null) {
            if(curr.data > x) {
                break;
            }
            
            prev = curr;
            curr = curr.next;
        }
        
        
        if(curr != null) { // It means that node(x) need to be inserted in between sorted DLL
            prev.next = temp;
            temp.prev = prev;
            
            temp.next = curr;
            curr.prev = temp;
        }
        // curr == null
        // Case 4 : It means that node(x) need to be inserted at the last of sorted DLL
        else {
            prev.next = temp;
            temp.prev = prev;
        }
        
        return head;
    }
    
}


