// construct bst from preorder traversal
public class BSTfromPreorder {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Index {
        int index = 0;
    }

    static Index in = new Index();

    static Node base(int[] pre, int size) {
        return util(pre, in, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }

    static Node util(int pre[], Index preIn, int key, int min, int max, int size) {
        if (preIn.index >= size)
            return null;
        Node root = null;
        if (key > min && key < max) {
            root = new Node(key);
            preIn.index += 1;
            if (preIn.index < size) {
                root.left = util(pre, preIn, pre[preIn.index], min, key, size);
                root.right = util(pre, preIn, pre[preIn.index], key, max, size);
            }
        }
        return root;
    }

    static void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        // BinaryTree tree = new BinaryTree();
        int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
        int size = pre.length;

        // Function call
        Node root = base(pre, size);
        System.out.println(
                "Inorder traversal of the constructed tree is ");
        inorder(root);
    }
}
