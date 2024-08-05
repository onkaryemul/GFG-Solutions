//{ Driver Code Starts
// Initial Template for JAVA

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


// } Driver Code Ends

// User function Template for Java

/*
class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/


// Generic Class
class Pair<T, U> {
    T first; // Node
    U second; // line ie. vertical position
    
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    
    public T getFirst() {
        return this.first;
    }
    
    public U getSecond() {
        return this.second;
    }
}


class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Level Order Traversal
    
    // Function to return a list of nodes visible from the top view from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> topViewOrder = new ArrayList<>(); // list to store the result
        
        // Edge case/Corner case 
        // Check if the tree is empty
        if(root == null) {
            return topViewOrder;
        }
        
        // Map to store the top view nodes based on their vertical position
        // Key: line or vertical position
        // Value: Value of first node in that line or vertical position
        Map<Integer, Integer> map = new TreeMap<>();
        
        // Queue for BFS traversal
        // Each element in queue is a pair containing node & its vertical position (line)
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0)); // push the root node with its vertical position 0 into the queue
        
        // BFS traversal
        while(!queue.isEmpty()) {
            Pair<Node, Integer> pair = queue.poll(); // retrieve the node and its vertical position from the front of the queue
            Node node = pair.getFirst();
            int line = pair.getSecond();
            
            // Check if the vertical position (line) is not already present in the map
            // If not present, then add the node's data to the map
            if(!map.containsKey(line)) {
                map.put(line, node.data);
            }
            
            // Process left child
            if(node.left != null) {
                queue.add(new Pair<>(node.left, line-1)); // push the left child with a decreased vertical position into the queue
            }
            
            // Process right child
            if(node.right != null) {
                queue.add(new Pair<>(node.right, line+1)); // push the right child with an increased vertical position into the queue
            }
        }
        
        // Transfer values from the map into the topViewOrder list
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            topViewOrder.add(entry.getValue());
        }
        
        return topViewOrder;
    }
    
}



//{ Driver Code Starts.

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();

            ArrayList<Integer> vec = ob.topView(root);
            for (int x : vec) System.out.print(x + " ");
            System.out.println();

            t--;
        }
    }
}
// } Driver Code Ends