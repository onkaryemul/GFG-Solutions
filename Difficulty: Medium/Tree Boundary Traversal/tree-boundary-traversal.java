//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
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
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


/*
class Node  { 
    int data; 
    Node left, right; 
   
    public Node(int d) { 
        data = d; 
        left = right = null; 
    } 
}
*/


//User function Template for Java
class Solution{
    
    // TC : O(n)
    // SC : O(Height of the tree)
    
    // Main function to perform the boundry traversal of the binary tree
	ArrayList<Integer> boundary(Node root) {
	    ArrayList<Integer> boundaryPath = new ArrayList<>();
	    
	    // Edge case: If tree is empty, then return an empty arraylist
	    if(root == null) {
	        return boundaryPath;
	    }
	    
	    // If the root is not a leaf node, then add its value to the boundaryPath list
	    if(!isLeafNode(root)) {
	        boundaryPath.add(root.data);
	    }
	    
	    // Steps for boundry traversals : Left boundary, leaves and right boundary in order
	    addLeftBoundary(root, boundaryPath);
	    
	    addLeaves(root, boundaryPath);
	    
	    addRightBoundary(root, boundaryPath);
	    
	    return boundaryPath;
	}
	
	
	// Function to check if a node is a leaf node 
    private boolean isLeafNode(Node root) {
        return root.left == null && root.right == null;
    }
	
	
	// Function to add the left boundary nodes of the tree
	private void addLeftBoundary(Node root, ArrayList<Integer> list)  {
	    Node curr = root.left;
	    
	    while(curr != null) {
	        // If the current node is not a leaf, then add its value to the list
	        if(!isLeafNode(curr)) {
	            list.add(curr.data);
	        }
	        
	        // Move to the left child if it exists, otherwise move to the right child
	        if(curr.left != null) {
	            curr = curr.left;
	        }
	        else {
	            curr = curr.right;
	        }
	    }
	    
	}
	
	
	// Function to add the leaves of the tree
	private void addLeaves(Node root, ArrayList<Integer> list) {
	    // Base case
	    // If the current node is a leaf node, then add its value to the result
	    if(isLeafNode(root)) {
	        list.add(root.data);
	        return;
	    }
	    
	    // Recursively add leaves of the left and right subtrees
	    if(root.left != null) {
	        addLeaves(root.left, list);
	    }
	    
	    if(root.right != null) {
	        addLeaves(root.right, list);
	    }
	}
	
	
	// Function to add the right boundary of the tree
    private void addRightBoundary(Node root, ArrayList<Integer> list) {
        Node curr = root.right;
        
        List<Integer> temp = new ArrayList<>();
        
        while(curr != null) {
            // If the current node is not a leaf node, then add its value to a temporary list
            if(!isLeafNode(curr)) {
                temp.add(curr.data);
            }
            
            // Move to the right child if it exists, otherwise move to the left child
            if(curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        
        // Reverse and add the values from the temporary list to the list
        int size = temp.size();
        for(int i=size-1; i >= 0; i--) {
            list.add(temp.get(i));
        }
    }
    
}

