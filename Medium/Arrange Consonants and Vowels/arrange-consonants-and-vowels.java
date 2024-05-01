//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/


class Solution {
    
    // Function to rearrange the linked list in such a way that all the vowels come before the consonants while maintaining the order of their arrival
    public Node arrangeCV(Node head){
        // write code here and return the head of changed linked list
        
        // Base case
        // if head is null or there's only one node, return head
        if(head == null || head.next == null) {
            return head;
        }
        
        // Set of vowels
        HashSet<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        
        Node temp = head;
        Node tail = null;
        int cons = 0, length = 0;
        
        // Calculate the number of consonants and the length of the linked list
        while(temp != null) {
            if(!vowelSet.contains(temp.data)) {
                cons++;
            }
            
            length++;
            
            if(temp.next == null) {
                tail = temp;
            }
            
            temp = temp.next;
        }
        
        // Edge case
        // If all characters are vowels or all characters are consonants, return head
        if(cons == 0 || length == cons) {
            return head;
        }
        
        // Move all the initial consonants to the end of the linked list
        while(head != null && !vowelSet.contains(head.data)) {
            Node x = head;
            head = head.next; // move head to next node
            
            tail.next = x;
            x.next = null;
            tail = x;
            
            cons--;
        }
        
        temp = head;
        Node prev = null;
        
        // Rearrange the remaining nodes according to the given condition
        while(cons > 0) {
            if(tail == temp) {
                break;
            }
            
            if(!vowelSet.contains(temp.data)) {
                if(prev != null) {
                    prev.next = temp.next;
                }
                
                tail.next = temp;
                temp.next = null;
                tail = temp;
                
                cons--;
                
                if(prev == null) {
                    temp = head;
                } 
                else {
                    temp = prev.next;
                }
            }
            else {
                prev = temp;
                temp = temp.next;
            }
        }
        
        return head;   
    }
    
}



/*   
   // Function to check if a character is a vowel
    boolean isVowel(char val) {
        return val == 'a' || val == 'e' || val == 'i' || val == 'o' || val == 'u';
    }

    // Function to rearrange the linked list based on vowels and consonants
    public Node arrangeCV(Node head) {
        if (head.next == null) return head;

        Node temp = head;
        Node dVowel = new Node('0'); // Dummy node for vowels
        Node dConsonant = new Node('0'); // Dummy node for consonants
        Node itVowel = dVowel;
        Node itConsonant = dConsonant;

        while (temp != null) {
            if (isVowel(temp.data)) {
                itVowel.next = temp;
                itVowel = itVowel.next;
            } else {
                itConsonant.next = temp;
                itConsonant = itConsonant.next;
            }
            temp = temp.next;
        }

        // Terminate the consonant list and link the end of the vowel list to the start of the consonant list
        itConsonant.next = null;
        itVowel.next = dConsonant.next;

        // Return the head of the vowel list
        return dVowel.next;
    }
*/

