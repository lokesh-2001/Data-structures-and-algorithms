public class basicStructure{
    
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
    public void insert(Node node, int val){
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
    public void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.println(node.data + " ");
            inorder(node.right);
        }   
    }
    public static void main(String args[]){
        basicStructure tree = new basicStructure();
        Node root  = new Node(5);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 5);
        tree.insert(root, 6);
        tree.insert(root, 7);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 9);
        tree.inorder(root);
    }
}