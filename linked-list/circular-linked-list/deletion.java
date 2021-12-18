public class deletion {
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
    public static void main(String[] args) {
        Node head = null;
 
        /* Created linked list will be 2.5.7.8.10 */
        head = insert(head, 2);
        head = insert(head, 5);
        head = insert(head, 7);
        head = insert(head, 8);
        head = insert(head, 10);
 
        System.out.printf("List Before Deletion: ");
        print(head);
 
        head = deleteNode(head, 7);
 
        System.out.printf("List After Deletion: ");
        print(head);
    }
}
