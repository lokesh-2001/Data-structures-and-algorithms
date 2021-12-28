package javaImplementation;

import java.util.*;

public class StringToBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    static int index(String str, int si, int ei) {
        if (si > ei)
            return -1;
        Stack<Character> s = new Stack<>();
        for (int i = si; i <= ei; i++) {
            if (str.charAt(i) == '(')
                s.add(str.charAt(i));
            else if (str.charAt(i) == ')') {
                if (s.peek() == '(') {
                    s.pop();
                    if ((s.isEmpty()))
                        return i;
                }
            }
        }
        return -1;
    }

    static Node treeFromString(String str, int si, int ei) {
        if (si > ei)
            return null;
        Node root = new Node(str.charAt(si) - '0');
        int index = -1;
        if (si + 1 <= ei && str.charAt(si + 1) == '(')
            index = index(str, si + 1, ei);
        if (index != -1) {
            root.left = treeFromString(str, si + 2, index - 1);
            root.right = treeFromString(str, index + 2, ei - 1);
        }
        return root;
    }

    public static void main(String[] args) {
        String str = "4(2(3)(1))(6(5))";
        Node root = treeFromString(str, 0, str.length() - 1);
        preorder(root);
    }
}
