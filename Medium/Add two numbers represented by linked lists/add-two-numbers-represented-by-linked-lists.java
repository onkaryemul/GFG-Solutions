//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

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
    
    // Time Complexity: O(N+M)
    // Space Complexity: O(Max(N,M))
        
        
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2){
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


