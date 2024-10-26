//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
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

// complete the below function
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using Simple Linked List Traversal
    
    // function to return the count of occurrence of an integer key in a linked list
    public static int count(Node head, int key) {
        // code here
        int cnt = 0;
        
        Node curr = head;
        
        while(curr != null) {
            if(curr.data == key) {
                cnt++;
            }
            curr = curr.next;
        }
        
        return cnt;
    }
    
}


//{ Driver Code Starts.

class LinkedList {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            int key = Integer.parseInt(br.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(head, key));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends