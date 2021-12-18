// split a circular linked list into 2 halves
public class split {
    static class Node{
        int data;
        Node next;
    }
    static Node newNode(int d){
        Node n = new Node();
        n.data = d;
        n.next = null;
        return n;
    }
    static Node insert(Node head, int d){
        Node h = newNode(d);
        h.next = head;
        if(head!=null){
            Node temp = head;
            while(temp.next!=head)
                temp = temp.next;
            temp.next = h;
        }
        else    
            h.next= h;
        head = h;
        return head;
    }
    static void print(Node head){
        Node temp = head;
        if(head!=null){
            do{
                System.out.println(temp.data + " ");
                temp = temp.next;
            }while(temp!=head);
        }
        System.out.println();
    }
    static Node deleteNode(Node head, int d){
        if(head==null)
            return null;

        Node curr = head,prev = new Node();
        while(curr.data!=d){
            if(curr.next==head){
                System.out.println("Not found");
                break;
            }
            prev=curr;
            curr= curr.next;
        }
        if(curr == head && curr.next == head ){
            head = null;
            return head;
        }
        if(curr==head){
            prev=head;
            while(prev.next!=head)
                prev=prev.next;
            head = curr.next;
            prev.next = head;
        }
        else if(curr.next == head)
            prev.next = head;
        else
            prev.next = curr.next;

        return head;
    }

    static void splitList(Node head){
        Node temp1 = head,temp2 = head;
        Node head1 = null, head2 = null;
        if(head == null)
            return;
        while(temp2.next!=head && temp2.next.next != head){
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        if(temp2.next.next == head)
            temp2 = temp2.next;
        head1 = head;
        if(head.next!=head)
            head2 = temp1.next;
        temp2.next = temp1.next;
        temp1.next = head; 
        System.out.println("First linked list");
        print(head1);
        System.out.println();
        System.out.println("second linked list");
        print(head2);
    }

    public static void main(String[] args) {
        Node head = null;
        head = insert(head, 2);
        head = insert(head, 5);
        head = insert(head, 7);
        head = insert(head, 8);
        head = insert(head, 10);
        splitList(head);  
    }

}
