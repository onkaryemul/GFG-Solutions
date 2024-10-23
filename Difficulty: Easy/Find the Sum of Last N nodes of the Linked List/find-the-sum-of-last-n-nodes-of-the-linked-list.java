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
Node class is as follows:

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
    
    // TC : O(n), single-pass solution
    // SC : O(1)

    // Return the sum of last k nodes
    public int sumOfLastN_Nodes(Node head, int n) {
        // write code here
        
        // 1. Traverse first n nodes of linked list using temp node
        Node temp = head;
        int i = 0;
        
        // Move temp node n steps ahead
        while(i < n) {
            temp = temp.next;
            i++;
        }
        
        // temp => point to nth node from the start of linked list
        
        // 2. Traverse linked list using another node i.e curr => starting from 1st node
        Node curr = head;
        
        // Move both temp and curr node until temp reaches the end
        while(temp != null) {
            curr = curr.next;
            temp = temp.next;
        }
        
        // Now, curr will point to (len - n)th node i.e nth node from the end of linked list
        
        // 3. Calculate the sum from the current node to the end
        int sum = 0;
        
        while(curr != null) {
            sum += curr.data;
            curr = curr.next;
        }
        
        return sum;
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
            int n = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            Solution ob = new Solution();
            System.out.println(ob.sumOfLastN_Nodes(head, n));
        }
    }
}

// } Driver Code Ends