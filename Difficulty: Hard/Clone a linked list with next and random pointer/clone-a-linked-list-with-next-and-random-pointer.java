//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next, random;

    Node(int d) {
        data = d;
        next = random = null;
    }
}

class Cloning {

    public static Node addToTheLast(Node head, Node node) {
        if (head == null) {
            return node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
            return head;
        }
    }

    public static boolean validation(Node head, Node res) {
        Node temp1 = head;
        Node temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        if (len1 != len2) return false;

        HashMap<Node, Node> nodeMap = new HashMap<>();

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1 == temp2) return false;
            if (temp1.data != temp2.data) return false;

            if ((temp1.random == null && temp2.random != null) ||
                (temp1.random != null && temp2.random == null)) {
                return false;
            }
            if (temp1.random != null && temp2.random != null &&
                temp1.random.data != temp2.random.data) {
                return false;
            }
            nodeMap.put(temp1, temp2);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1.random != null && nodeMap.get(temp1.random) != temp2.random) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline after the integer input

        while (t-- > 0) {
            Node head = null, head2 = null;
            String line = sc.nextLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = Arrays.stream(numsStr).mapToInt(Integer::parseInt).toArray();

            int n = nums.length;
            head = addToTheLast(head, new Node(nums[0]));
            head2 = addToTheLast(head2, new Node(nums[0]));

            for (int i = 1; i < n; i++) {
                head = addToTheLast(head, new Node(nums[i]));
                head2 = addToTheLast(head2, new Node(nums[i]));
            }

            String line2 = sc.nextLine().trim();
            String[] numsStr2 = line2.split(" ");
            int[] nums2 = Arrays.stream(numsStr2).mapToInt(Integer::parseInt).toArray();
            int q = nums2.length / 2;

            for (int i = 0; i < q; i++) {
                int a = nums2[2 * i];
                int b = nums2[2 * i + 1];

                Node tempA = head;
                Node temp2A = head2;
                for (int j = 0; j < a - 1 && tempA != null; j++) {
                    tempA = tempA.next;
                    temp2A = temp2A.next;
                }
                Node tempB = head;
                Node temp2B = head2;
                for (int j = 0; j < b - 1 && tempB != null; j++) {
                    tempB = tempB.next;
                    temp2B = temp2B.next;
                }

                if (a <= n) {
                    tempA.random = tempB;
                    temp2A.random = temp2B;
                }
            }

            Solution g = new Solution();
            Node res = g.copyList(head);

            if (validation(head, res) && validation(head2, res))
                System.out.println("true");
            else
                System.out.println("false");
        }
        sc.close();
    }
}

// } Driver Code Ends


/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.
*/

/*
class Node {
    int data; // Data stored in the node
    Node next; // Pointer to the next node
    Node random; // Pointer to a random node in the list

    // Constructors for Node class
    
    // Default constructor
    Node() {
        this.data = 0;
        this.next = null;
        this.random = null;
    }
    
    // Constructor with data
    Node(int d) {
        data = d;
        this.next = null;
        this.random = null;
    }
    
    // Constructor with data, next, and random pointers
    Node(int x, Node nextNode, Node randomNode) {
        this.data = x;
        this.next = nextNode;
        this.random = randomNode;
    }
}
*/


class Solution {

    // TC : O(3N)
    // SC : O(1), not including the resultant copy list which we have to return 
    
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // your code here
        // Base case/Edge case
        if(head == null) { // If original list is empty, then return null
            return null;
        }
        
        // Step 1 : Insert copy of nodes in between
        insertCopyInBetween(head);
        
        // Step 2 : Connect random pointers of copied nodes
        connectRandomPointers(head);
        
        // Step 3 : Retrieve the deep copy of the linked list
        return getDeepCopyList(head);
    }
    
    
    // Helper function -> to insert a copy of each node in between the original nodes
    private void insertCopyInBetween(Node head) {
        Node temp = head;
        
        while(temp != null) {
            Node nextNode = temp.next;
            
            // Create a new node with the same data
            Node copyNode = new Node(temp.data);
            
            // Point the copyNode's next to the original node's next
            copyNode.next = nextNode;
            
            // Point the original node's next to the copyNode
            temp.next = copyNode;
            
            // Move to the next original node
            temp = nextNode;
        }
    }
    
    
    // Helper function -> to connect pointers of the copied nodes
    private void connectRandomPointers(Node head) {
        Node temp = head;
        
        while(temp != null) {
            // Access the copied node
            Node copyNode = temp.next;
            
            // If the original node has a random pointer
            if(temp.random != null) {
                // Point the copied node's random to the corresponding copied random node
                copyNode.random = temp.random.next;
            }
            else {
                // Set the copied node's random to null if the original node random is null
                copyNode.random = null;
            }
            
            // Move to the next original node
            temp = temp.next.next;
        }
    }
    
    
    // Helper function -> to retrieve the deep copy of the linked list
    private Node getDeepCopyList(Node head) {
        Node temp = head;
        
        // Create a dummy node
        Node dummyNode = new Node(-1);
        
        // Initialize a result pointer
        Node res = dummyNode;
        
        while(temp != null) {
            // Creating a new list by pointing to copied nodes
            res.next = temp.next;
            
            res = res.next;
            
            // Disconnect & revert back to the initial state of the original linked list
            temp.next = temp.next.next;
            
            temp = temp.next;
        }
        
        return dummyNode.next;
    }
    
}



/*   
    // TC : O(2N)
    // SC : O(N) -> since using hashmap to store original nodes with their copied nodes
    

    // Function to clone the linked list
    public static Node cloneLL(Node head) {
        Node temp = head;
        
        // Create a HashMap to map original nodes to their corresponding copied nodes
        HashMap<Node, Node> map = new HashMap<>();

        // Step 1: Create copies of each node and store them in the map
        while (temp != null) {
            // Create a new node with the same data as the original node
            Node newNode = new Node(temp.data);
            
            // Map the original node to its corresponding copied node in the map
            map.put(temp, newNode);
            
            // Move to the next node in the original list
            temp = temp.next;
        }

        temp = head;
        
        // Step 2: Connect the next and random pointers of the copied nodes using the map
        while (temp != null) {
            // Access the copied node corresponding to the current original node
            Node copyNode = map.get(temp);
            
            // Set the next pointer of the copied node to the copied node mapped to the next node in the original list
            copyNode.next = map.get(temp.next);
            
            // Set the random pointer of the copied node to the copied node mapped to the random node in the original list
            copyNode.random = map.get(temp.random);
            
            // Move to the next node in the original list
            temp = temp.next;
        }

        // Return the head of the deep copied list from the map
        return map.get(head);
    }
*/


