package javaImplementation;

// Find all Duplicate subtrees in a Binary tree
import java.util.HashMap;

public class DuplicateSubtrees {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static HashMap<String, Integer> hm;

    static String inorder(Node node) {
        if (node == null)
            return "";
        String str = "(";
        str += inorder(node.left);
        str += Integer.toString(node.data);
        str += inorder(node.left);
        str += ")";
        if (hm.get(str) != null && hm.get(str) == 1)
            System.out.print(node.data + " ");

        if (hm.containsKey(str))
            hm.put(str, hm.get(str) + 1);
        else
            hm.put(str, 1);

        return str;
    }
    static void print(Node node){
        hm = new HashMap<>();
        inorder(node);
    }
    public static void main(String[] args) {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        print(root);
    }
}
