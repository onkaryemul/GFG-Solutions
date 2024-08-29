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

public class LinkedList {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0) return;

        Node curr = head;
        for (int i = 1; i < x; i++) curr = curr.next;

        tail.next = curr;
    }

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
            int k = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            makeLoop(head, tail, k);

            Solution ob = new Solution();
            System.out.println(ob.countNodesinLoop(head));
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


// Function should return the length of the loop in LL
class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using two pointeres (slow and fast) to detect the loop without any significant extra memory usage
    
    // Function to find the length of a loop in the linked list
    public int countNodesinLoop(Node head) {
        // Add your code here
        Node slow = head;
        Node fast = head;
        
        // Step 1 : Traverse the list to detect a loop
        while(fast != null && fast.next != null) {
            slow = slow.next; // move slow one step
            fast = fast.next.next; // move fast two steps
            
            // Step 2 : If the slow and fast pointers meet, there is a loop
            if(slow == fast) {
                return findLengthOfLoop(slow, fast);
            }
        }
        
        // Step 3 : If the fast pointer reaches the end, there is no loop
        return 0; 
    }
    
    
    // Function to return the length of loop when slow & fast are on the same node
    private int findLengthOfLoop(Node slow, Node fast) {
        // count to keep track of nodes encountered in loop
        int cnt = 1;
        
        fast = fast.next; // move fast by one step
        
        // traverse fast till it reaches back to slow
        while(fast != slow) {
            cnt++; 
            fast = fast.next;
        }
        
        // loop terminates when fast reaches slow again & the cnt is returned
        return cnt;
    }
    
}


