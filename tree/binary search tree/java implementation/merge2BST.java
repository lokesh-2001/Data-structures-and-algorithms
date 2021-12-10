public class merge2BST{
    private static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    private static void merge(Node root1, Node root2){
        // for bst 1
        SNode s1 = new SNode();
        Node current1 = root1;
        // for bst 2
        SNode s2 = new SNode();
        Node current2 = root2;

        if(root1 == null){
            inorder(root2);
            return;
        }
        if(root2 == null){
            inorder(root1);
            return;
        }
        while(current1 != null || current2!=null || !s1.isEmpty() || !s2.isEmpty()){
            if(current1!=null || current2!=null){
                // reach the leftmost nodes of both bsts
                if(current1!=null){
                    s1.push(current1);
                    current1 = current1.left;
                }
                if(current2!=null){
                    s2.push(current2);
                    current2 = current2.left;
                }            
            }
            else{
                // if a null node is reached and either of the stacks is empty
                // one tree is empty, print the other tree
                if(s1.isEmpty()){
                    while(!s2.isEmpty()){
                        current2 = s2.pop();
                        current2.left = null;
                        inorder(current2);
                    }
                    return;
                } 
                if(s2.isEmpty()){
                    while(!s2.isEmpty()){
                        current1 = s1.pop();
                        current1.left = null;
                        inorder(current1);
                    }
                    return;
                } 

                current1 = s1.pop();
                current2 = s2.pop();
                // if element of 1st tree is smaller then print it
                // and push the right subtree if the elements is larger,
                // then we push it back to the corresponding stack
                if(current1.data < current2.data){
                    System.out.print(current1.data + " ");
                    current1 = current1.right;
                    s2.push(current2);
                    current2 = null;
                }
                else{
                    System.out.print(current2.data + " ");
                    current2 = current2.right;
                    s1.push(current1);
                    current1 = null;
                }
            }
        }
        
        System.out.println(s1.t);
        System.out.println(s2.t);

    }
    public static void main(String[] args) {
        Node root1 = null, root2 =null;
        root1 = new Node(3);
        root1.left  = new Node(1);
        root1.right = new Node(5);

        root2 = new Node(4);
        root2.left  = new Node(2);
        root2.right = new Node(6);
        merge(root1, root2);
    }
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left =  null;
            this.right =  null;
        }
    }
    // stack node
    static class SNode{
        SNode head;
        SNode next;
        Node t;
        void push(Node k){
            SNode  temp = new SNode();
            temp.t = k;
            temp.next = this.head;
            this.head = temp;
        }
        Node pop(){
            SNode st;
            st = this.head;
            head = head.next;
            return st.t;
        }
        boolean isEmpty(){
            if(this.head == null)
                return true;
            return false;
        }
    }
}
// time complexity O(m+n)
// space complexity O(height of 1st tree + height of second tree)