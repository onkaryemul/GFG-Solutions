//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Main {
    public static void push(DLLNode tail, int new_data) {
        DLLNode newNode = new DLLNode(new_data);
        newNode.next = null;
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }
    }

    public static void printList(DLLNode head) {
        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] arr = br.readLine().trim().split(" ");
            int k = Integer.parseInt(br.readLine().trim());

            DLLNode head = new DLLNode(Integer.parseInt(arr[0]));
            DLLNode tail = head;

            for (int i = 1; i < arr.length; i++) {
                push(tail, Integer.parseInt(arr[i]));
                tail = tail.next;
            }

            Solution obj = new Solution();
            DLLNode sorted_head = obj.sortAKSortedDLL(head, k);
            printList(sorted_head);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // TC : O(n*logk)
    // SC : O(k)
    
    // Using Min-Heap (PriorityQueue)
    
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Code here
        // 1. Create a Min-Heap (PriorityQueue)
        PriorityQueue<DLLNode> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        
        // 2. Push first (k+1) elements of DLL in to the priority queue
        // since, it is given that each node is at most k-indices away from its target position
        int i = 0;
        while(i <= k && head != null) {
            pq.add(head);
            head = head.next;
            i++;
        }
        
        // 3. Build the sorted DLL 
        // By popping until priority queue is empty
        DLLNode newHead = null;
        DLLNode curr = null;
        
        while(!pq.isEmpty()) {
            if(newHead == null) {
                newHead =  pq.poll();
                newHead.prev = null;
                newHead.next = null;
                curr = newHead;
            }
            else {
                curr.next = pq.poll();
                curr.next.prev = curr;
                curr = curr.next;
            }
            
            if(head != null) {
                pq.add(head);
                head = head.next;
            }
        }
        
        curr.next = null;
        
        return newHead;
    }
    
}


