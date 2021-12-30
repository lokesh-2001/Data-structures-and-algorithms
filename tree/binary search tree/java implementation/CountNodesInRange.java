// Count BST nodes that lie in a given range
public class CountNodesInRange {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }   
    static int count(Node node, int low, int high){
        if(node == null)
            return 0;
        if(node.data >=low && node.data<=high)
            return 1 + count(node.left, low, high) + count(node.right, low, high); 
        else if(node.data < low)
            return count(node.right, low, high); 
        return count(node.left, low, high); 
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left     = new Node(5);
        root.right     = new Node(50);
        root.left.left = new Node(1);
        root.right.left = new Node(40);
        root.right.right = new Node(100);
        System.out.println(count(root, 5, 45));
    }

}
