public class insertion {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;   
        }
    }
    public static insertion insert(insertion li, int data){
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
    public static void print(insertion li){
        Node temp = li.head;
        System.out.println("Linked List: ");
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        insertion li = new insertion();
        li = insert(li,1);
        li = insert(li,45);
        li = insert(li,12);
        li = insert(li,74);
        li = insert(li,96);
        li = insert(li,35);
        li = insert(li,20);
        print(li);
    }
}
