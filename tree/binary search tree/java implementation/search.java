public class search {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    static void insert(Node node, int val){
        if(val<node.data){
            if(node.left != null){
                insert(node.left,val);
            }
            else{
                System.out.println("Inserted " + val + " to the left of " + node.data);
                node.left = new Node(val);
            }
        }
        else if(val>node.data){
            if(node.right != null){
                insert(node.right,val);
            }
            else{
                System.out.println("Inserted " + val + " to the right of " + node.data);
                node.right = new Node(val);
            }

        }
    }
    static void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }   
    }
    static Node searchNode(Node root, int key){
        if(root == null || root.data == key)
            return root;
        if(root.data < key)
            return searchNode(root.right, key);
        return searchNode(root.left, key);
    } 
    public static void main(String args[]){
        // basicStructure tree = new basicStructure();
        Node root  = new Node(5);
        insert(root, 2);
        insert(root, 4);
        insert(root, 5);
        insert(root, 6);
        insert(root, 7);
        insert(root, 1);
        insert(root, 3);
        insert(root, 9);
        inorder(root);
        System.out.println();
        System.out.println(searchNode(root,5).data);
    }
}

