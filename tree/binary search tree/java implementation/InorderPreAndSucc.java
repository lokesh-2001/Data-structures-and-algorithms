// Inorder predecessor and successor for a given key in BST
public class InorderPreAndSucc {
    static class Node {
        int data;
        Node left, right;

        Node() {
        }

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    static void insert(Node node, int val) {
        if (val < node.data) {
            if (node.left != null) {
                insert(node.left, val);
            } else {
                node.left = new Node(val);
            }
        } else if (val > node.data) {
            if (node.right != null) {
                insert(node.right, val);
            } else {
                node.right = new Node(val);
            }

        }
    }

    static Node pre = new Node(), suc = new Node();

    static void find(Node root, int d) {
        if (root == null)
            return;
        if (root.data == d) {
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null)
                    temp = temp.right;
                pre = temp;
            }
            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null)
                    temp = temp.left;
                suc = temp;
            }
            return;
        }
        if (root.data > d) {
            suc = root;
            find(root.left, d);
        }
        if (root.data < d) {
            pre = root;
            find(root.right, d);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        // insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
             inorder(root);
        System.out.println();
        System.out.println("root->" + root.data);
        find(root, 65);
        if (pre != null)
            System.out.println("Predecessor is " + pre.data);
        else
            System.out.println("No Predecessor");

        if (suc != null)
            System.out.println("Successor is " + suc.data);
        else
            System.out.println("No Successor");
    }

}
