//{ Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
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
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}


// } Driver Code Ends


class Pair<T, U> {
    T first; // node
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


//User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Level Order Traversal
    
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> bottomViewOrder = new ArrayList<>();
        
        // Edge case/Corner case
        // Check if the tree is empty
        if(root == null) { 
            return bottomViewOrder;
        }
        
        // Map to store the bottom view nodes based on their vertical positions
        // Key: Vertical Position
        // Value: last node in level order traversal for that vertical position
        Map<Integer, Integer> map = new TreeMap<>();
        
        // Queue for BFS traversal, each element is a pair containing node and its vertical position
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        // Push the root node with its vertical position 0 into the queue
        queue.add(new Pair<>(root, 0));
        
        // BFS traversal - Level Order traversal
        while(!queue.isEmpty()) {
            // Retrieve the node and its vertical position from the front of the queue
            Pair<Node, Integer> pair = queue.poll();
            Node node = pair.getFirst();
            int line = pair.getSecond();
            
            // Update the map with the node's data for the current vertical position
            map.put(line, node.data);
            
            // Process left child
            if(node.left != null) {
                queue.add(new Pair<>(node.left, line-1)); // push the left child with a decreased vertical positino into the queue
            }
            
            // Process right child
            if(node.right != null) {
                queue.add(new Pair<>(node.right, line+1)); // push the right child with an incresed vertical position into the queue
            }
        }
        
        // Transfer values from the map into the bottomViewOrder list
        for(Integer value : map.values()) {
            bottomViewOrder.add(value);
        }
        
        return bottomViewOrder;
    }
    
}

