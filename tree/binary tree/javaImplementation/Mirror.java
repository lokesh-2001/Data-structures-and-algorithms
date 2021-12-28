package javaImplementation;

public class Mirror {
    static class Node{
        int data;
        Node left, right;
    }
    static Node createNode(int d){
        Node temp = new Node();
        temp.data = d;
        temp.left = temp.right = null;
        return temp;
    }
    static void inorder(Node root){
        if(root == null)
            return ;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    static Node mirror(Node root){
        if(root == null)
            return null;
        Node left  = mirror(root.left);
        Node right  = mirror(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
    public static void main(String[] args) {
        Node root = createNode(1);
        root.left = createNode(2);
        root.right = createNode(3);
        root.left.left = createNode(4);
        root.left.right = createNode(5);
        inorder(root);
        System.out.println();
        mirror(root);
        inorder(root);
    
    }
}
