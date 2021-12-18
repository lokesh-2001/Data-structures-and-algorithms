public class reverse {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    Node reverseIter(Node node){
        Node prev = null;
        Node curr = node;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }
        node = prev;
        return node;
    }
    Node revereRecur(Node node){
        if(node == null || node.next == null)
            return node;
        Node temp = revereRecur(node.next);
        node.next.next = node;
        node.next = null;
        return temp;
    }

    public static reverse insert(reverse li, int data){
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
    public static void print(reverse li){
        Node temp = li.head;
        System.out.println("Linked List: ");
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        reverse li = new reverse();
        li = insert(li,1);
        li = insert(li,45);
        li = insert(li,12);
        li = insert(li,74);
        li = insert(li,96);
        li = insert(li,35);
        li = insert(li,20);
        print(li);
        li.head = li.reverseIter(li.head);
        System.out.println();
        print(li);
        System.out.println();
        li.head = li.revereRecur(li.head);
        System.out.println();
        print(li);

    }

}
