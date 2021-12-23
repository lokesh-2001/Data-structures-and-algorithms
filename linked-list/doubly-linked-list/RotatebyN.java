// rotate doubly linked list by n nodes
public class RotatebyN {
    static class Node{
        int data;
        Node next,prev;
        Node(int d){
            data = d;
            next = prev = null;
        }
    }
    static Node rotateByN(Node head, int x){
        if(x == 0)
            return null;
        Node temp = head;
        while(x!=0){
           temp = temp.next;
           x--; 
        }
        Node last = temp.prev;
        Node newHead = temp;
        last.next = null;
        temp.prev = null;
        
        while(temp.next!=null)
            temp = temp.next;
        temp.next = head;
        head.prev = temp;
        head = newHead;
        return head;
    }
    static Node push(Node head, int d){
        Node temp = new Node(d);
        temp.prev = null;
        temp.next = head;
        if(head!=null)
            head.prev = temp;
        head = temp;
        return temp;
    }
    static void print(Node temp){
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(8);
        head = push(head, 56);
        head = push(head, 12);
        head = push(head, 2);
        head = push(head, 6);
        head = push(head, 3);
        System.out.println("Before rotation: ");
        print(head);
        System.out.println();
        System.out.println();
        head = rotateByN(head, 2);
        System.out.println("After rotation: ");
        print(head);
    }

}
