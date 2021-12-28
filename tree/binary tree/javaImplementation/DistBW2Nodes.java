package javaImplementation;
// Find distance between 2 nodes in a Binary tree
public class DistBW2Nodes {
    static class Node{
        int data;
        Node left, right ;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static Node LCA(Node root,int n1, int n2){
        if(root == null)
            return root;
        if(root.data == n1 || root.data == n2)
            return root;
        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);
        if(left!=null && right!=null)
            return root;
        if(left==null && right==null)
            return null;
        if(left !=null)
            return LCA(root.left, n1, n2);
        return LCA(root.right, n1, n2);
    }
    static int level(Node root, int a, int l){
        if(root == null)
            return -1;
        if(root.data == a)
            return l;
        int left = level(root.left, a, l+1);
        if(left == -1)
             return level(root.right, a, l+1);
        return left;
    }
    static int findDistance(Node root, int a, int b){
        Node lca = LCA(root, a, b);
        int d1 = level(lca, a, 0);
        int d2 = level(lca, b, 0);
        return d1 + d2;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Dist(4, 5) = "
                           + findDistance(root, 4, 5));
 
        System.out.println("Dist(4, 6) = "
                           + findDistance(root, 4, 6));
 
        System.out.println("Dist(3, 4) = "
                           + findDistance(root, 3, 4));
 
        System.out.println("Dist(2, 4) = "
                           + findDistance(root, 2, 4));
 
        System.out.println("Dist(8, 5) = "
                           + findDistance(root, 8, 5));
    }
}

