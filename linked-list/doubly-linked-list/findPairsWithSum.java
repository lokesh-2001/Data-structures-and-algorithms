// find pairs with given su in doubly linked list
public class findPairsWithSum {
    static class Node{
        int data;
        Node prev,next;
    }    
    static Node newNode(int d){
        Node n = new Node();
        n.data = d;
        n.prev = n.next = null;
        return n;
    }
    static Node insert(Node h1, int n){
        Node temp = newNode(n);
        if(h1==null)
            return temp;
        else{
            temp.next = h1;
            h1.prev = temp;
            h1 = temp;
        }
        return temp;
    }
    static void findPair(Node h1, int x){
        Node first  = h1;
        Node second = h1;
        while(second.next!=null)
            second = second.next;
        boolean found = false;
        while(first!=second && second.next!=first){
            if(first.data + second.data == x){
                found = true;
                System.out.println("{ " + first.data + " , " + second.data + " }");
                first = first.next;
                second = second.prev;
            }
            else{
                if(first.data + second.data < x)
                    first = first.next;
                else
                    second = second.prev;
            }
        }
        if(!found)
            System.out.println("Noe found");
    }
    public static void main(String[] args) {
        Node head = null;
        head = insert(head, 9);
        head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);
        int x = 7;
     
        findPair(head, x);
    }
}
