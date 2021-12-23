public class SegregateEvenOddNodes {
    static class Node{
        int data;
        Node next;
    }   
    Node(int d){
        data = d;
        next = null;
    }
    static Node segregate(){
        Node evenStart = null, evenEnd = null,oddStart =null,oddEnd = null;
        Node curr = head;
        while(curr!=null){
            if(curr.data % 2 == 0){
                if(evenStart== null){
                    evenStart = curr;
                    evenEnd = curr;
                }
                else{
                    evenEnd.next = curr;
                    evenEnd = curr;
                }
            }
            else{
                if(oddStart== null){
                    oddStart = curr;
                    oddEnd = curr;
                }
                else{
                    oddEnd.next = curr;
                    oddEnd = curr;
                }

            }
            curr = curr.next;            
        }
        if(evenStart == null || oddStart == null)
            return null;
        
        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;
        return head;
    } 
    static void print(Node head){
        
        while(head!=null){
            System.out.println("head : " + head.data + " random : " + head.random.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println("original list: ");
        print(head);
        System.out.println();

        Node copy = segregated(head);
        System.out.println("segregated list: ");
        // print(head);
        print(copy);
        

    }
}
