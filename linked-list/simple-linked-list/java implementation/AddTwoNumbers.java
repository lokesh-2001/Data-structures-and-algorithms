public class AddTwoNumbers {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    static void addPrecedingZeroes(Node start1, Node start2){
        Node next1  = start1.next;
        Node next2  = start2.next;
        while(next1!=null && next2!=null){
            next1 = next1.next;
            next2 = next2.next;
        }
        if(next1==null && next2!=null){
            while(next2!=null){
                Node temp = new Node(0);
                temp.next = start1.next;
                start1.next = temp;
                next2 = next2.next;
            }
        }
        else if(next2==null && next1!=null){
            while(next1!=null){
                Node temp = new Node(0);
                temp.next = start2.next;
                start2.next = temp;
                next1 = next1.next;
            }
        }    
    }
    static int addNodes(Node first, Node second, Node result){
        if(first == null)
            return 0;
        int no = first.data + second.data + addNodes(first.next,second.next,result);
        Node temp = new Node(no%10);
        temp.next = result.next;
        result.next = temp;
        return no/10;
    }
    static void addLists(Node first, Node second){
        Node start1 = new Node(0);
        start1.next = first;
        Node start2 = new Node(0);
        start2.next = second;
        addPrecedingZeroes(start1, start2);
        Node result = new Node(0);
        if(addNodes(start1.next,start2.next,result)==1){
            Node node = new Node(1);
            node.next = result.next;
            result.next = node;
        }
        print(result.next);
    }
    static void print(Node head){
        while(head!=null){
            System.out.print( head.data + "");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(5);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(6);

        System.out.println("List 1: ");
        print(head1);
        System.out.println();
        Node head2 = new Node(8);
        head2.next = new Node(4);
        System.out.println();

        System.out.println("List 2: ");
        print(head2);
        System.out.println();

        System.out.println("Resultant List: ");
        addLists(head1,head2);
        System.out.println();



    }
}

