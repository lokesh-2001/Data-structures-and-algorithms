// using morris inorder traversal
// Find median of BST in O(n) time and O(1) space
public class median {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);

        return node;
    }

    static int count(Node root) {
        Node curr, pre;
        int count = 0;
        if (root == null)
            return count;
        curr = root;
        while (curr != null) {
            if (curr.left == null) {
                count++;
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    count++;
                    curr = curr.right;
                }
            }
        }
        return count;
    }

    static int find(Node node) {
        if (node == null)
            return 0;
        int count = count(node);
        int currCount = 0;
        Node curr = node, prev = null, pre = null;
        while (curr != null) {
            if (curr.left == null) {
                currCount++;
                if (count % 2 != 0 && currCount == (count + 1) / 2)
                    return prev.data;
                else if (count % 2 == 0 && currCount == (count / 2) + 1)
                    return (prev.data + curr.data) / 2;

                prev = curr;
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    prev = pre;
                    currCount++;
                    if (count % 2 != 0 && currCount == (count + 1) / 2)
                        return curr.data;
                    else if (count % 2 == 0 && currCount == (count / 2) + 1)
                        return (curr.data + prev.data) / 2;

                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Node root = null; 
        root = insert(root, 50); 
        insert(root, 30); 
        insert(root, 20); 
        insert(root, 40); 
        insert(root, 70); 
        insert(root, 60); 
        insert(root, 80); 
      
        System.out.println("Median of BST is " + find(root)); 
    }
}
