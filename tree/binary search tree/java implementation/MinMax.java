public class MinMax {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }   
    }
    static int min(Node root){
        int min = root.data;
        while(root.left!=null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
    static int max(Node root){
        int max = root.data;
        while(root.right!=null){
            max = root.right.data;
            root = root.right;
        }
        return max;
    }
    static void insert(Node node, int val){
        if(val<node.data){
            if(node.left != null){
                insert(node.left,val);
            }
            else{
                System.out.println("Inserted " + val + " to the left of " + node.data);
                node.left = new Node(val);
            }
        }
        else if(val>node.data){
            if(node.right != null){
                insert(node.right,val);
            }
            else{
                System.out.println("Inserted " + val + " to the right of " + node.data);
                node.right = new Node(val);
            }

        }
    }
    public static void main(String[] args) {
        Node root  = new Node(5);
        insert(root, 2);
        insert(root, 4);
        insert(root, 5);
        insert(root, 6);
        insert(root, 7);
        insert(root, 1);
        insert(root, 3);
        insert(root, 9);
        inorder(root);
        System.out.println();
        System.out.println("root->" +  root.data);
        System.out.println("Minimum Value "+min(root));
        System.out.println();
        System.out.println("MAximum Value "+max(root));

    }
}
