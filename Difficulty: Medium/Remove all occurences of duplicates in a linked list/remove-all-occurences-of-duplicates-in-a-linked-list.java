//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GFG {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            GFG llist = new GFG();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            Solution ob = new Solution();
            head = ob.removeAllDuplicates(llist.head);
            llist.printList(head);

            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Sorted Linked list
    public Node removeAllDuplicates(Node head) {
        // code here
        Node res = new Node(-1);
        res.next = head;
        
        Node preptr = res;
        
        Node curr = head;
        while(curr != null) { // traversing till end
            while(curr.next != null && preptr.next.data == curr.next.data) {
                curr = curr.next;
            }
            
            // 2 cases
            // Case 1: 21 -> 23 -> 23 -> 23 -> N
            if(preptr.next == curr) {
                preptr = preptr.next;
            }
            // Case 2: 23 -> 23 -> 23 -> N
            else {
                preptr.next = curr.next;
            }
            
            curr = curr.next;    
        }
        
        return res.next;
    }
    
}

