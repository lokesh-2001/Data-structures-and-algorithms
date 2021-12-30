// Replace every element with the least greater element on its right
public class replaceNext {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node succ = null, root = null;

    static Node insert(Node node, int val) {
        if (node == null)
            node = new Node(val);
        if (val < node.data) {
            succ = node;
            node.left = insert(node.left, val);
        } else if (val > node.data)
            node.right = insert(node.right, val);
        return node;
    }

    static void replace(int arr[], int n) {
        succ = null;
        for (int i = n - 1; i >= 0; i--) {
            root = insert(root, arr[i]);
            if (succ != null)
                arr[i] = succ.data;
            else
                arr[i] = -1;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 8, 58, 71, 18, 31,
                32, 63, 92, 43, 3,
                91, 93, 25, 80, 28 };
        int n = arr.length;

        replace(arr, n);

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
