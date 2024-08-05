//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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

class GfG {

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
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.diameter(root));
            t--;
        }
    }
}

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


class Solution {
    
    // TC : O(n)
    // SC : O(Height of the tree)
    
    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        // Your code here
        int[] diameter = new int[1]; // Initialize the variable to store the diameter of the tree
        diameter[0] = 0; 
        
        height(root, diameter); // call the height function to traverse the tree and calculate diameter
        
        return diameter[0] + 1; // return the calculated diameter
    }
    
    
    // Function to calculate the height of the tree and update the diameter 
    private int height(Node root, int[] diameter) {
        // Base case: If the node is null, return 0 indicating the height of an empty tree
        if(root == null) {
            return 0;
        }
        
        // Recursively calculate the height of the left and right subtrees
        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);
        
        diameter[0] = Math.max(diameter[0], lh+rh); // update the diameter with the maximum of current diameter or sum of left and right heights
        
        // return the height of the current node's subtree
        return 1 + Math.max(lh, rh);
    }
    
    
}

