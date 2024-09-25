//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);

            System.out.println(f ? "true" : "false");
        }
    }
}

// } Driver Code Ends


/* 
Structure of class Node is:

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
    
    // TC : O(n)
    // SC : O(1)
    
    // Optimized Approach
    // 1. Find the middle node of linked list
    // 2. Reverse the second half 
    // 3. Compare 1st half with 2nd half
    
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        // Your code here
        // Base case / Edge case
        // Check if linked list has only one node, ie. single node is also a palindrome
        if(head.next == null) { // have single node
            return true;
        }
        
        // 1. Find the middle node of linked list 
        Node slow = head, fast = head, preptrslow = null;
        
        while(fast != null && fast.next != null) {
            preptrslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // separate the first half
        preptrslow.next = null;
        
        // 2. Reverse the second half
        Node secondHead = reverse(slow);
        
        // 3. Compare the two list (1st half and 2nd half)
        while(head != null && secondHead != null) {
            if(head.data != secondHead.data) {
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        
        return true;
    }
    
    
    // Helper function
    // to reverse the singly linked list
    private Node reverse(Node head) {
        Node curr = head, prev = null, next = null;
        
        while(curr != null) {
            next = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            
            curr = next;
        }
        
        return prev;
    }
    
}


/*
Approach 1 : Using Stack Space

TC : O(n)
SC : O(n)

    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        
        Node curr = head;
        
        //add data to stack
        while(curr!=null){
            st.push(curr.data);
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr!=null){
            if(st.pop()!=curr.data)
               return false;
           
            curr=curr.next;
        }
        
        return true;
    }
*/

