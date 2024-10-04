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

class LinkedList {
    // Function to print nodes in a given circular linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int key = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make the list circular
            Solution ob = new Solution();
            Node current = ob.deleteNode(head, key);
            Node rev = ob.reverse(current);
            printList(rev);
        }
    }
}

// } Driver Code Ends


/*
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
    
    // TC : O(n) -> for both deleting a node in circular LL && reversing a circular LL
    // SC : O(1)
    
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        // code here
        // Make single LL from circular LL
        Node curr = head;
        
        while(curr.next != head) {
            curr = curr.next;
        }
        
        curr.next = null;
        
        // 2. Reverse the single LL
        Node originalHead = head;
        
        Node newHead = reverseIt(head);
        
        // 3. Again, establish the link to make it circular LL
        originalHead.next = newHead;
        
        return newHead;
    }


    // Helper function --> to reverse a single linked list
    private Node reverseIt(Node head) {
        Node prev = null, curr = head, next = null;
        
        while(curr != null) {
            next = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            
            curr = next;
        }
        
        return prev;
    }
    

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        // code here
        // 1. Check if the node with value(=key) is present in given circular LL
        Node curr = head.next;
        
        boolean isFound = false;
        
        while(curr != head) {
            if(curr.data == key) {
                isFound = true;
            }
            curr = curr.next;
        }
        
        if(head.data == key) {
            isFound = true;
        }
        
        // if key is not found in given circular LL
        if(!isFound) {
            return head;
        }
        
        // otherwise, if found
        // 2. Get the node with value key
        curr = head;
        
        while(curr.data != key) {
            curr = curr.next;
        }
        
        // Now, curr --> point to the node with value key
        
        // 3. We need to delete curr node
        // to delete that node, we need to access it's prev node
        Node prev = head;
        
        while(prev.next != curr) {
            prev = prev.next;
        }
        
        // 4. finally, make connection to remove curr node
        prev.next = prev.next.next;
        
        return head.data == key ? head.next : head;
    }
    
}

