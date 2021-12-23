// merge k sorted linked lists
public class MergeK {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    static Node merge2Lists(Node head1, Node head2){
        Node result = null;
        if(head1== null)
            return head2;
        if(head2== null)
            return head1;
        if(head1.data <= head2.data){
            result = head1;
            result.next  = merge2Lists(head1.next, head2);
        }
        else{
            result = head2;
            result.next  = merge2Lists(head1, head2.next);
        }
        return result;
    }
    static Node mergeK(Node head[], int n){
        while(n!=0){
            int i = 0 , j = n;
            while(i<j){
                head[i] = merge2Lists(head[i], head[j]);
                i++;
                j--;
                if(i>=j)
                    n = j;
            }
        }
        return head[0];
    }
    static void print(Node temp){
        System.out.println("Linked List: ");
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        int k = 3, n = 4;
        Node head[] = new Node[k];
        head[0] = new Node(1);
        head[0].next = new Node(4);
        head[0].next.next = new Node(7);
        head[0].next.next.next = new Node(10);

        head[1] = new Node(2);
        head[1].next = new Node(5);
        head[1].next.next = new Node(8);
        head[1].next.next.next = new Node(11);

        head[2] = new Node(3);
        head[2].next = new Node(6);
        head[2].next.next = new Node(9);
        head[2].next.next.next = new Node(12);

        Node list = mergeK(head, k-1);
        print(list);

    }
}
