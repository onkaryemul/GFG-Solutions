//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}

public class Main {
    public static void print(Node root) {
        Map<Node, Integer> link = new HashMap<>();
        Node temp = root;
        int index = 0;

        // Store node addresses and their index
        while (temp != null) {
            link.put(temp, index++);
            temp = temp.next;
        }

        temp = root;
        System.out.print("[");
        while (temp != null && temp.next != null) {
            if (temp.random == null) {
                System.out.print("[" + temp.data + ", NULL], ");
            } else {
                System.out.print("[" + temp.data + ", " + (link.get(temp.random) + 1) +
                                 "], ");
            }
            temp = temp.next;
        }
        if (temp != null) {
            if (temp.random == null) {
                System.out.print("[" + temp.data + ", NULL]]\n");
            } else {
                System.out.print("[" + temp.data + ", " + (link.get(temp.random) + 1) +
                                 "]]\n");
            }
        }
    }

    public static Node buildLinkedList(List<int[]> v, Map<Node, Integer> orgAddress) {
        List<Node> address = new ArrayList<>(v.size());
        Node head = new Node(v.get(0)[0]);
        address.add(head);
        orgAddress.put(head, 0);
        Node temp = head;

        for (int i = 1; i < v.size(); i++) {
            Node newNode = new Node(v.get(i)[0]);
            orgAddress.put(newNode, i);
            address.add(newNode);
            temp.next = newNode;
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < v.size(); i++) {
            int randomIndex = v.get(i)[1];
            if (randomIndex != -1) {
                temp.random = address.get(randomIndex - 1);
            }
            temp = temp.next;
        }

        return head;
    }

    public static boolean validateInput(Map<Node, Integer> orgAddress, Node head,
                                        List<int[]> v) {
        List<Node> address = new ArrayList<>(v.size());
        Node temp = head;

        for (int i = 0; i < v.size(); i++) {
            if (!orgAddress.containsKey(temp) || orgAddress.get(temp) != i) {
                return false;
            }
            address.add(temp);
            temp = temp.next;
        }

        if (temp != null) {
            return false;
        }

        temp = head;
        for (int i = 0; i < v.size(); i++) {
            int value = v.get(i)[0];
            int randomIndex = v.get(i)[1];

            if (randomIndex == -1) {
                if (temp.random != null) {
                    return false;
                }
            } else {
                Node tempNode = address.get(randomIndex - 1);
                if (temp.random != tempNode) {
                    return false;
                }
            }
            temp = temp.next;
        }
        return true;
    }

    public static boolean validation(Node res, Map<Node, Integer> orgAddress) {
        Node temp = res;
        while (temp != null) {
            if (orgAddress.containsKey(temp)) {
                return false;
            }
            if (orgAddress.containsKey(temp.random)) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            List<int[]> v = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                String y = sc.next();
                int randomIndex = y.equals("NULL") || y.equals("N") ||
                                          y.equals("null") || y.equals("n") ||
                                          y.equals("Null")
                                      ? -1
                                      : Integer.parseInt(y);
                v.add(new int[] {x, randomIndex});
            }
            Map<Node, Integer> orgAddress = new HashMap<>();
            Node head = buildLinkedList(v, orgAddress);

            Solution solution = new Solution();
            Node res = solution.cloneLinkedList(head);

            // Validate if input is modified
            if (validateInput(orgAddress, head, v)) {
                if (validation(res, orgAddress)) {
                    print(res);
                } else {
                    System.out.println("Pointing to the original list");
                }
            } else {
                System.out.println("Input list modified");
            }
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


/*
linked list node

class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/


class Solution {
    
    // TC : O(3N)
    // SC : O(1), not including the resultant copy list which we have to return 
    
    // Function to clone a linked list with next and random pointer.
    public Node cloneLinkedList(Node head) {
        // code here
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
    
------------------------------------------------------------------------------------------------

    Node *cloneLinkedList(Node *head) {
        // STEP 1 input list ki nodes ke beech me op list ki node hume rkhni hai mapping create
        if(head==NULL) 
            return head;
            
        Node * temp=head;
        
        while(temp){
            Node *n=new Node(temp->data);
            n->next=temp->next;
            temp->next=n;
            temp=n->next;
        }
        
        //STEP 2 random pointer assing krde clone ll me
        temp=head;
        
        Node *head2=temp->next;
        
        while(temp!=NULL){
            if(temp->random==NULL){
                temp->next->random=NULL;
            }
            else
                 temp->next->random=temp->random->next;
            temp=temp->next->next;
        }
        
        // STEP 3 op list return krde
        temp = head;
        
        while(temp!=NULL){
            Node* temp2=temp->next;
            
            temp->next=temp2->next;
            
            if(temp2->next)
               temp2->next=temp2->next->next;
               
            temp=temp->next;
        }
        
        return head2;
    }
*/

