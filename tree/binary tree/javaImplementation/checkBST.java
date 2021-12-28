package javaImplementation;

public class checkBST {
    static int prev = Integer.MIN_VALUE;

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static boolean isBST(Node root) {
        if (root != null) {
            if (!isBST(root.left))
                return false;
            if (root.data <= prev)
                return false;
            prev = root.data;
            return isBST(root.right);
        }
        return true;
    }

    static boolean check(Node root) {
        return isBST(root);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        if (check(root))
            System.out.print("Is BST");
        else
            System.out.print("Not a BST");
    }
}
