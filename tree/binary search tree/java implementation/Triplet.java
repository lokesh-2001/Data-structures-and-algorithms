// find if there is a triplet in a balanced BST that adds to zero
//convert given bst to doubly linked list
public class Triplet {
    static class node{
        int key;
        node left,right;
    };
    static node head;
    static node tail;
    static void convert(node root){
        if(root==null)
            return;
        if(root.left!=null)
            convert(root.left);
        root.left = tail;
        if(tail!=null)
            tail.right = root;
        else
            head = root;
        tail = root;
        if(root.right!=null)
            convert(root.right);
    }
    static boolean isPresent(node head, node tail , int sum){
        while(head!=tail){
            int curr = head.key + tail.key;
            if(curr== sum)
                return true;
            else if(curr>sum)
                tail = tail.left;
            else
                head = head.right;

        }
        return false;
    }
    static boolean isTripletPresent(node root){
        if(root == null)
            return false;
        head = null;
        tail = null;
        convert(root);
        while((head.right!=tail) && (head.key<0)){
            if(isPresent(head.right,tail,-1*head.key)){
                return true;
            }   
            else
            head = head.right;  
        }

        return false;

    }
    static node newNode(int num){
        node temp = new node();
        temp.key = num;
        temp.left = temp.right = null;
        return temp;
    }

    static node insert(node root, int key){
        if(root==null)
            return newNode(key);
        if(root.key>key)
            root.left = insert(root.left,key);
        else    
            root.right = insert(root.right, key);
        return root;
    }
    public static void main(String[] args) {
        node root = null;
        root = insert(root,6);
        root = insert(root,-13);
        root = insert(root,14);
        root = insert(root,-8);
        root = insert(root,15);
        root = insert(root,13);
        root = insert(root,7);
        if(isTripletPresent(root))
            System.out.println("present");
        else
            System.out.println("not present");

    }
}
