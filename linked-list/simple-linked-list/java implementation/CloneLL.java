// clone a linked list with next and random pointer in O(1) space
public class CloneLL{
    static class Node{
        int data;
        Node next;
        Node random;
        Node(int d){
            data = d;
            next = random = null;
        }
    }
    static void print(Node head){
        
        while(head!=null){
            System.out.println("head : " + head.data + " random : " + head.random.data);
            head = head.next;
        }
    }
    static Node clone(Node head){
        Node temp1 = head, temp = null;
        while(temp1!=null){
            temp = temp1.next;
            temp1.next = new Node(temp1.data);
            temp1.next.next = temp;
            temp1 = temp;
        }
        temp1 = head;
        while(temp1!=null){
            if(temp1.next!=null)
                temp1.next.random = (temp1.random!=null) ? temp1.random.next :temp1.random;
            temp1 = temp1.next.next;
        }
        Node original = head, copy = head.next;
        temp = copy;
        while(original!=null){
            original.next = original.next.next;
            copy.next = (copy.next!=null) ? copy.next.next :copy.next ;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    } 

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        head.random = head.next.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        System.out.println("original list: ");
        print(head);
        System.out.println();

        Node copy = clone(head);
        System.out.println("clone list: ");
        // print(head);
        print(copy);
    }
}