//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/


class Solution {
    
    public Node sort(Node head){
        //your code here, return the head of the sorted list
        Node h1 = new Node(-1);
        Node h2 = new Node(-1);
        
        Node ch1 = h1, ch2 = h2;
        
        Node curr = head;
        
        while(curr != null) {
            ch1.next = curr;
            ch1 = ch1.next;
            
            curr = curr.next;
            
            // even nodes --> 2nd list
            if(curr != null) {
                ch2.next = curr;
                
                ch2 = ch2.next;
                
                curr = curr.next;
            }
            
            ch1.next = null;
            ch2.next = null;
        }
        
        h1 = h1.next;
        h2 = h2.next;
        
        h2 = reverseList(h2); // reverse second list
        
        return merge(h1, h2); // merge two lists
    }

   
    private Node reverseList(Node head) {
        Node prev=null, current = head, next;
        
        while(current != null) {
            next = current.next;
            
            current.next = prev;
            
            prev = current;
            current = next;
        }
        
        return prev;
    }
   
    
    private Node merge(Node r1, Node r2) {
        Node dummy = new Node(0);
        
        Node current = dummy;
        
        while(r1 != null && r2 != null) {
            if(r1.data < r2.data) {
                current.next = r1;
                r1 = r1.next;
            } else {
                current.next = r2;
                r2 = r2.next;
            }
            current = current.next;
        }
        
        if(r1 != null) {
            current.next = r1;
        } else {
            current.next = r2;
        }
        
        return dummy.next;
    }
    
}

