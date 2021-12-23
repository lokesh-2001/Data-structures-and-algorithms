// Delete nodes having greater value on right
public class deleteNodesGreater {
    class Node{
        int data;
        Node next;
        Node(int d){
            data  = d;
            next = null;
        }
    }   
    Node head;
    void deleteNodes(){

        reverseIter();
        deleteLesserNodes();
        reverseIter();

    }
    void deleteLesserNodes(){
        Node curr = head;
        Node max = head;
        Node temp;
        while(curr!=null && curr.next!=null){
            if(curr.next.data < max.data){
                temp = curr.next;
                curr.next = temp.next;
                temp = null;
            }
            else{
                curr = curr.next;
                max = curr;
            }
        }
    }
    void reverseIter(){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }
        head = prev;
    }
    void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    void push(int d){
        Node temp = new Node(d);
        temp.next = head;
        head = temp;
    }
    public static void main(String[] args) {
        deleteNodesGreater li = new deleteNodesGreater();
        li.push(3);
        li.push(2);
        li.push(6);
        li.push(5);
        li.push(11);
        li.push(10);
        li.push(15);
        li.push(12);
        System.out.println("Linked list: ");
        li.print();
        System.out.println();
        li.deleteNodes();
        System.out.println("Linked list after deletion: ");
        li.print();
        System.out.println();

    }
}
