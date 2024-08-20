//{ Driver Code Starts
//Initial Template for Java


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
			if (i >= ip.length)
				break;

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
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


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
    

//User function Template for Java
class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using BFS (Breadth first search)
    public static int minTime(Node root, int target) {
        // Your code goes here
        Node temp = root;
        
        // mapping of each node with its parent node
        HashMap<Node, Node> parentMap = new HashMap<>();
        
        // this will return the mapping of each node with its parent, and finally return node with target data
        Node targetNode = updateParentMap(parentMap, root, target); 
        
        // Apply BFS starting from targetNode
        // using queue & visited set
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        
        queue.add(targetNode);
        visited.add(targetNode);
        
        int time = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            int isBurn = 0;
            
            // Process nodes at each level
            while(size-- > 0) {
                Node currNode = queue.poll();
                
                // Check if its left child exist & it is not visited
                if(currNode.left != null && !visited.contains(currNode.left)) {
                    isBurn = 1;
                    queue.add(currNode.left);
                    visited.add(currNode.left);
                }
                
                // Check if its right child exist & it is not visited
                if(currNode.right != null && !visited.contains(currNode.right)) {
                    isBurn = 1;
                    queue.add(currNode.right);
                    visited.add(currNode.right);
                }
                
                // Check if its parent exist && it is not visited
                if(parentMap.get(currNode) != null && !visited.contains(parentMap.get(currNode))) {
                    isBurn = 1;
                    queue.add(parentMap.get(currNode));
                    visited.add(parentMap.get(currNode));
                }
            }
            
            // Check if atleast one new node is set on fire for these level
            if(isBurn == 1) {
                time++;
            }
        }
        
        return time;
    }
    
    
    // Function to map each node with its parent node & finally return the node with target data
    private static Node updateParentMap(HashMap<Node, Node> parentMap, Node root, int target) {
        // Apply BFS starting from root of the binary tree
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        Node targetNode = new Node(-1); // pointer to a node with target data
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size-- > 0) {
                Node currNode = queue.poll();
                
                // Check if current node's data is equal to the target
                if(currNode.data == target) {
                    targetNode = currNode; // targetNode will now point to the node with target data
                }
                
                // Check if its left child exists
                if(currNode.left != null) {
                    queue.add(currNode.left);
                    parentMap.put(currNode.left, currNode); // map left child with current node
                }
                
                // Check if its right child exists
                if(currNode.right != null) {
                    queue.add(currNode.right);
                    parentMap.put(currNode.right, currNode); // map right child with current node
                }
            }
        }
        
        return targetNode;
    }
    
}


