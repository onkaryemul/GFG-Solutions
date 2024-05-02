//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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

    static void deletetree(Node root) {
        if (root == null) return;
        deletetree(root.left);
        deletetree(root.right);
        root.left = null;
        root.right = null;
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
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Tree tr = new Tree();
            ArrayList<Integer> A = tr.serialize(root);
            deletetree(root);
            root = null;

            Node getRoot = tr.deSerialize(A);
            printInorder(getRoot);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the given function
Node is as follows:
class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}*/


class Tree {
    
    // Function to serialize a tree and return a list containing nodes of tree.
    private ArrayList<Integer> al;
    
    public ArrayList<Integer> serialize(Node root) {
        // code here
        al = new ArrayList<Integer>();
        serializeHelper(root);
        return al;
    }
    
    
    private void serializeHelper(Node root) {
        // Base case
        if(root == null) {
            al.add(-1);
            return;
        }
        
        al.add(root.data);
        serializeHelper(root.left);
        serializeHelper(root.right);
    }
    
    
    // Function to deserialize a list and construct the tree.
    private int index;

    public Node deSerialize(ArrayList<Integer> A) {
        // code here
        index = 0;
        return dfs(A);
    }
    
    private Node dfs(ArrayList<Integer> A) {
        // Base case
        if(index == A.size()) {
            return null;
        }
        
        int val = A.get(index);
        index++;
        
        // edge case
        if(val == -1) {
            return null;
        } 
        
        Node root = new Node(val);
        root.left = dfs(A);
        root.right = dfs(A);
        
        return root;
    }
    
};

