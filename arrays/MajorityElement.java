import java.io.*;
class Node{
    int key;
    int count = 0 ;
    Node left,right;
}
public class MajorityElement{
    static Node newNode(int item){
        Node temp = new Node();
        temp.key = item;
        temp.count = 1;
        temp.left = temp.right = null;
        return temp;
    }

    static int max = 0;
    static Node insert(Node node, int key){
        if(node == null){
            if(max==0)
                max=1;
            
            return newNode(key); 
        }
        if(key<node.key)
            node.left = insert(node.left,key);
        else if(key>node.key)
        node.right = insert(node.right,key);
        else
            node.count++;

        max = Math.max(max,node.count); 
        return node;
    }
    static void inorderMajority(Node root, int size){
        if(root!=null){
            inorderMajority(root.left,size);
            if(root.count > (size/2))
                System.out.println(root.key + " ");
                inorderMajority(root.right,size);
        }
    }
    public static void main(String[] args){
        int a[] = {1,3,3,3,2,3};
        int size = a.length;
        Node root = null;
        for(int i = 0;i<size;i++){
            root = insert(root,a[i]);
        }
        if (max > (size / 2))
            inorderMajority(root, size);
        else
            System.out.println("No majority element\n");
    }
}