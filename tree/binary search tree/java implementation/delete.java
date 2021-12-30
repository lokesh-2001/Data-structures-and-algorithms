public class delete {
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
    static Node  deletion(Node root, int d){
        if(root == null)
            return root;
        if(d < root.data)
            root.left = deletion(root.left, d);
        else if(d > root.data)
            root.right = deletion(root.right, d);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            
            root.data = minValue(root);
            root.right = deletion(root.right, root.data);
        }
        return root;
    } 
    static int minValue(Node root){
        int min = root.data;
        while(root.left!=null){
            min = root.left.data;
            root = root.left;
        }
        return min;
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
        System.out.println("root->" +  root.data);
        System.out.println(deletion(root,5).data);
        System.out.println();
        System.out.println("root->" +  root.data);
    }
}
