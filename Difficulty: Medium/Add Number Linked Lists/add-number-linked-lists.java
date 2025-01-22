//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends


/* 
node for linked list

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
    
    // Time Complexity: O(n + m)
    // Space Complexity: O(max(n, m))
        
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        // return head of sum list
        Node temp = null;
        while(num1 != null && num1.data == 0) {
            temp = num1;
            num1 = num1.next;
        }
        
        if(temp != null) {
            temp.next = null;
        }
        
        while(num2 != null && num2.data == 0) {
            temp = num2;
            num2 = num2.next;
        }
        
        if(temp != null) {
            temp.next = null;
        }
        
        // Base cases
        if(num1 == null && num2 == null) {
            return new Node(0);
        }
        
        if(num1 == null) {
            return num2;
        }
        
        if(num2 == null) {
            return num1;
        }
        
        // reverse the two linked lists
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        Node head1 = num1;
        Node head2 = num2;
        
        temp = new Node(-1);
        Node ans = temp;
        
        int carry = 0;
        
        while(head1 != null && head2 != null) {
            int sum = head1.data + head2.data + carry;
            carry = sum / 10;
            
            temp.next = new Node(sum%10);
            temp = temp.next;
         
            head1 = head1.next;
            head2 = head2.next;
        }
        
        while(head1 != null) {
            int sum = head1.data + carry;
            carry = sum/10;
            
            temp.next = new Node(sum%10);
            temp = temp.next;
            
            head1 = head1.next;
        }
        
        while(head2 != null) {
            int sum = head2.data + carry;
            carry = sum/10;
            
            temp.next = new Node(sum%10);
            temp = temp.next;
            
            head2 = head2.next;
        }
        
        if(carry != 0) {
            temp.next = new Node(carry);
        }
        
         
        return reverse(ans.next);
    }
    
    
    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
}



//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends