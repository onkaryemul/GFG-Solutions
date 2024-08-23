//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
    			ArrayList<Integer> result = g.leftView(root);
    			for(int value : result){
    			    System.out.print(value + " ");
    			}
    			System.out.println();
                t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/


class Tree {
    
    // TC : O(n)
    // SC : O(height of the tree) or O(n), indicating that we can use Iterative approach also (ie. level order traversal)
    
    
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
       // Your code here
       ArrayList<Integer> leftViewNodes = new ArrayList<>();
       
       recursiveLeftView(root, 0, leftViewNodes); // Preorder traversal: Root - Left - Right
       
       return leftViewNodes;
    }
    
    
    // Preorder Traversal : Root - Left - Right
    private void recursiveLeftView(Node root, int level, ArrayList<Integer> leftViewNodes) {
        // Base case
        if(root == null) {
            return;
        }
        
        // Check if the size of the leftViewNodes list is equal to the current level
        if(leftViewNodes.size() == level) { // if yes, then add the current node's data to the list
            leftViewNodes.add(root.data);
        }
        
        recursiveLeftView(root.left, level + 1, leftViewNodes); // left child with an increased level
    
        recursiveLeftView(root.right, level + 1, leftViewNodes); // right child with an increase level
    }
 
}

