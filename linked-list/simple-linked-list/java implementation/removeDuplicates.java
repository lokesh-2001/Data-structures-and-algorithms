public class removeDuplicates {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data  = d;
            next = null;
        }
    }   
    static void RemoveDuplicate(Node node){
        Node curr = node;
        while(curr!=null){
            Node temp = curr;
            while(temp!=null && temp.data == curr.data){
                temp = temp.next; 
            }
            curr.next = temp;
            curr = curr.next;
        }
    }
    static void print(Node node){
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(20);
        head.next = new Node(23); 
        head.next.next = new Node(23); 
        head.next.next.next = new Node(23); 
        head.next.next.next.next = new Node(23);
        head.next.next.next.next.next = new Node(25);
        System.out.println("ll before removal");
        print(head);
        System.out.println();
        System.out.println("ll after removal");
        RemoveDuplicate(head);
        print(head);

    }

}
