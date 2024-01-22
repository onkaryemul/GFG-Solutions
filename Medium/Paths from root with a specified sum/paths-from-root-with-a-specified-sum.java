//{ Driver Code Starts
import java.util.*;
import java.io.*;

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

public class GfG {
    public static Node buildTree(String str) {

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
    

    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        
        int t = Integer.parseInt(scn.nextLine()); 

        while (t-- > 0) 
        {
            int s = Integer.parseInt(scn.nextLine());
            // sc.nextLine();
            String res = scn.nextLine();
            // sc.nextLine();
            Node root = buildTree(res);
            
            Solution ob=new Solution();
            ArrayList<ArrayList<Integer>> ans= ob.printPaths(root, s);
            
            Collections.sort(ans, new ElementWiseComparator());
            
            for(int i=0;i<ans.size();i++)
            {
                for(int j=0;j<ans.get(i).size();j++)
                {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println(" ");
            }
        }
    }
    
    static class ElementWiseComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            int minLength = Math.min(list1.size(), list2.size());
    
            for (int i = 0; i < minLength; i++) {
                int comparison = Integer.compare(list1.get(i), list2.get(i));
                if (comparison != 0) {
                    return comparison;
                }
            }
    
            return Integer.compare(list1.size(), list2.size());
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*Tree Node
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


class Solution
{
    
    // helper function -> TC : O(N^2) & SC : O(N)
    // Recursive function
    private static void printPathsUtil(Node currNode, int sumSoFar, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans) {
        // Base case
        if(currNode == null) {
            return;
        }
        
        sumSoFar += currNode.data;
        
        path.add(currNode.data);
        
        if(sumSoFar == sum) {
            ans.add(new ArrayList<Integer>(path));
        }
        
        // Calling recursively on left subtree
        if(currNode.left != null) {
            printPathsUtil(currNode.left, sumSoFar, sum, path, ans);
        }
        
        // Calling recursively on right subtree
        if(currNode.right != null) {
            printPathsUtil(currNode.right, sumSoFar, sum, path, ans);
        }
        
        path.remove(path.size() - 1);   
    }
    
    
    // Main algorithm code
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum)
    {
        // code here
        ArrayList<Integer> path = new ArrayList<Integer>();
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        // calling helper function
        printPathsUtil(root, 0, sum, path, ans);
        
        return ans;
    }
}



