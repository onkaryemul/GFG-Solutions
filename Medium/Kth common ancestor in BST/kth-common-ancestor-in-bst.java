//{ Driver Code Starts
import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);

            String[] snums = br.readLine().split(" ");
            int k = Integer.parseInt(snums[0]);
            int x = Integer.parseInt(snums[1]);
            int y = Integer.parseInt(snums[2]);

            Solution T = new Solution();
            // Call the function with the needed parameters
            System.out.println(T.kthCommonAncestor(root, k, x, y));

            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    
    // TC : O(logn)  logn -> height of BST 
    // SC : O(logn)
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        // code here
        Node LCA = lca(root, x, y); // lowest common ancestor for BST --> O(logn) time complexity
        
        ArrayList<Integer> al = new ArrayList<>(); // for storing the path from root to lca
        
        search(root, LCA, al); // traversing from root to lca and storing path in arraylist al --> O(logn) time complexity
        
        return (al.size() - k < 0) ? -1 : al.get(al.size()-k); 
    }
    
    /*  
       // LCA for Binary Tree  -->  TC: O(n)
       Node lca(Node root, int n1,int n2) {
     		// Your code here
     		if(root==null)
     		return null;
    		
     		if(root.data==n1 || root.data== n2)
     		    return root;
    		
     		Node left = lca(root.left, n1,n2);
     		Node right = lca(root.right, n1,n2);
    		
     		if(left==null && right==null)
     		    return null;
    		
     		if(left!=null && right!=null)
     		    return root;
    		
     		if(left!=null && right==null)
     		    return left;
    		
    		else return right;
	   }
    
    */
    
    
    // TC : O(logn) --> height of tree
    private Node lca(Node root, int n1, int n2) {
        
        while(root != null) {
            if(root.data < n1 && root.data < n2) {
                root = root.right;
            }
            else if (root.data > n1 && root.data > n2) {
                root = root.left;
            } 
            else {
                break;
            }
        }
        
        return root;
    }
    
    
    // TC : O(logn)
    private void search(Node root, Node x, ArrayList<Integer> al) {
        while(root != null) {
            al.add(root.data);
            
            if(root.data == x.data) {
                return;
            }
            
            if(root.data < x.data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
    
}

