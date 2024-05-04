//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        // Base case
        if(n == 0) {
            return null;
        }
        
        return solve(in, post, 0, n-1, 0, n-1);
    }
    
    
    private Node solve(int[] in, int[] post, int inStart, int inEnd, int posStart, int posEnd) {
        // Base case
        if(inStart > inEnd) {
            return null;
        }
        
        if(inStart == inEnd) {
            return new Node(in[inStart]);
        }
        
        Node root = new Node(post[posEnd]);
        
        int idx = -1;
        for(int i=inStart; i <= inEnd; i++) {
            if(in[i] == post[posEnd]) {
                idx = i;
                break;
            }
        }
        
        int left = idx - inStart;
        int right = inEnd - idx;
        
        root.left = solve(in, post, inStart, idx-1, posStart, posStart+left-1);
        root.right = solve(in, post, idx+1, inEnd, posEnd-right, posEnd-1);
        
        return root;
    }
    
}

