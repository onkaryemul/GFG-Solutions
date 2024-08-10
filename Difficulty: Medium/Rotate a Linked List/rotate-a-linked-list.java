//{ Driver Code Starts
// Initial Template for Java

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


// } Driver Code Ends

/* 
node of linked list:

class Node {
    int data;
    Node next;
    
    Node(int d){
        data=d;
        next=null;
    }
}
*/


class Solution {
    
    // TC : O(n+k)
    // SC : O(1)
    
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        // Edge cases or Corner cases
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Compute the length
        int len = 1;
        Node curr = head;
        // Traverse till the last node of the given linked list
        while(curr.next != null) {
            len++;
            curr = curr.next;
        }
        
        // curr now points to the last node of the linked list
        curr.next = head;
        
        // k = k%len; // so that k lies in range 0 to n-1
        
        // Go till that node
        while(k-- > 0) {
            curr = curr.next;
        }
        
        // Make that node as head and break connection
        head = curr.next;
        curr.next = null;
        
        return head;
    }
    
}



//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}

// } Driver Code Ends