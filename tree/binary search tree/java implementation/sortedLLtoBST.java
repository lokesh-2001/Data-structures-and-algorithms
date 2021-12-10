// convert a sorted linked list to a balanced BST
public class sortedLLtoBST {

    static LNode head;
    class LNode{
        int data;
        LNode next, prev;
        LNode(int d){
            data = d;
            next = prev = null;
        }
    }
    class TNode{
        int data;
        TNode left, right;
        TNode(int d){
            data = d;
            left = right = null;
        }
    }
    int countNode(LNode head){
        int count = 0;
        while(head!=null){
            count ++;
            head = head.next;
        }
        return count;
    }

    // function to insert in the beginning of the DLL
    void push(int d){
        LNode newNode = new LNode(d);
        newNode.prev = null;
        newNode.next = head;
        if(head!= null)
            head.prev = newNode;
        head = newNode;
    }
    // function to print the nodes of the linked list
    void print(LNode node){
        while(node!=null){
            System.out.print(node.data + " ");
            node= node.next;
        }
    }
    // function to print preorder traversal of BST
    void preorder(TNode root){
        if(root== null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    // function to construct the bst 
    // n total number of nodes
    TNode construct(int n){
        if(n<=0)
            return null;
            TNode left = construct(n/2);
        TNode root = new TNode(head.data);
        root.left = left;
        head = head.next;
        root.right = construct(n - n/2 -1);
        // n total nodes n/2 nodes in left sub tree 1 is root
        return root;
    }
    TNode convert(){
        int count  = countNode(head);
        return construct(count);
    }

    public static void main(String[] args) {
        sortedLLtoBST ll = new sortedLLtoBST();
        // ll.push(2);
        // ll.push(74);
        // ll.push(45);
        // ll.push(96);
        // ll.push(22);
        // ll.push(52);
        // ll.push(37);
        // ll.push(83);
        // ll.push(25);
        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);

        System.out.println("Linked List: ");
        ll.print(head);
        TNode root = ll.convert();
        System.out.println();
        System.out.println("Pre order traversal");
        ll.preorder(root);

    }

}
