// reverse a linked list in a group of given size
public class revereSize {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    Node reverse(Node node, int k){
        if(node == null)
            return null;
        Node curr = node;
        Node next = null;
        Node prev = null;
        int count = 0 ;
        while(count<k && curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count ++;
        }
        if(next!=null)
            node.next = reverse(next, k);
        return prev;
    }
    public static revereSize insert(revereSize li, int data){
        Node newNode =new Node(data);
        newNode.next=null;
        if(li.head == null)
            li.head = newNode;
        else{
            Node temp = li.head;
            while(temp.next!=null)
                temp=temp.next;
            temp.next = newNode;
        }
        return li;
    }
    public static void print(revereSize li){
        Node temp = li.head;
        System.out.println("Linked List: ");
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        revereSize li = new revereSize();
        li = insert(li,1);
        li = insert(li,45);
        li = insert(li,12);
        li = insert(li,74);
        li = insert(li,96);
        li = insert(li,35);
        li = insert(li,20);
        print(li);
        li.head = li.reverse(li.head,2);
        System.out.println();
        print(li);

    }

}
