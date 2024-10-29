//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class SortLL {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(str[i]);
                addToTheLast(new Node(a));
            }

            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);

            printList(node);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }
}
// } Driver Code Ends


/*
Node class of the linked list

class Node {
    int data;
    Node next;
    
    Node(int key) {
        data = key;
        next = null;
    }
}
*/


// you have to complete this function
class GfG {
    
    // TC : O(n*logn), for best and average cases
    //    : O(n^2), for worst cases
    
    // SC : O(recursive stack space) => due to recursion
    
    
    // Using Quick Sort Algorithm
    // Divide and Conquer approach
    
    public static Node quickSort(Node node) {
        // Your code here
        myQuickSort(node, null);
        
        return node;
    }
    

    // Recursive Quick Sort function
    private static void myQuickSort(Node start, Node end) {
        // Base case
        if(start == null || start == end) {
            return;
        }
       
        Node pivot = partition(start, end);
        
        myQuickSort(start, pivot);
        
        myQuickSort(pivot.next, end);
        
        return;
    }
    
    
    // Helper function => 
    // partition() => to place pivot element at its correct position
    private static Node partition(Node start, Node end) {
        Node pivot = start; // pick start node as pivot element
        
        Node left = start;
        
        Node temp = start;
        while(temp != end) {
            // If curr node data < pivot node data, 
            // then swap (left+1)th node data with current node data
            if(temp.data < pivot.data) {
                swap(left.next, temp);
                left = left.next;
            }
            
            temp = temp.next;
        }
        
        // Swap the data at pivot node & left node
        swap(pivot, left); // => pivot will be placed at left node position 
        // & left node data (which is < pivot.data) => is moved to its origin i.e to left of pivot
        
        return left; // correct position of pivot in sorted LL
    }
    
    
    // Helper function => to swap data at two nodes
    private static void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
    
}

