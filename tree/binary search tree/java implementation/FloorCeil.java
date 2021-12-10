class FloorCeil{
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    private int ceil(Node root, int d){
        if(root == null){
            return -1;
        }
        if(root.data == d)
            return root.data;
        
        if(root.data<d)
            return ceil(root.right,d);
        
        int ceil = ceil(root.left,d);


        return (ceil>=d)?ceil:root.data;
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

    public static void main(String[] args) {
        FloorCeil tree = new FloorCeil();
        Node root = new Node(8);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 5);
        tree.insert(root, 6);
        tree.insert(root, 7);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 9);
        for(int i=0;i<16;i++)
            System.out.println( i + " " + tree.ceil(root, i));
    }
}