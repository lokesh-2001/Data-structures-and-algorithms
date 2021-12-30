public class kthlargest {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left= right = null;
        }
    }   
    static void insert(Node node, int val){
        if(val<node.data){
            if(node.left != null){
                insert(node.left,val);
            }
            else{
                node.left = new Node(val);
            }
        }
        else if(val>node.data){
            if(node.right != null){
                insert(node.right,val);
            }
            else{
                node.right = new Node(val);
            }

        }
    }
    static class count{
        int count = 0 ;
    }
    static void util(Node node, int k, count c){
        if(node == null || c.count>= k)
            return;
        util(node.right, k, c);
        c.count++;
        if(c.count == k){
            System.out.println( k +" : " + node.data);
            return;
        }
        util(node.left, k, c);
    }
    static void kth(Node node, int k){
        count c = new count();
        util(node, k, c);
    }
    static void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }   
    }
    public static void main(String args[]){
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
        for(int i=1;i<=9;i++){
            kth(root, i);
        }
    }
}
