// multiply two numbers represented by linked lists
public class Multiply2Numbers {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    static long multiply(Node first, Node second){
        long N = 1000000007; // 10^9 + 7
        long num1 = 0 , num2 = 0;
        while(first!=null || second!=null){
            if(first!=null){
                num1 = (num1*10)%N + first.data;
                first = first.next;
            }
            if(second!=null){
                num2 = (num2*10)%N + second.data;
                second = second.next;
            }
        }
        return ((num1%N) * (num2%N))%N;
    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);

        System.out.println(multiply(head1, head2)); 
    }
}
