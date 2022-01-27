// Implement a Circular queue
// * LINKED LIST IMPLEMENTATION
public class CircularQueueLL {
    static class Node {
        int data;
        Node next;
    }

    static class queue {
        Node front, rear;
    }

    static void enqueue(queue q, int val) {
        Node temp = new Node();
        temp.data = val;
        if (q.front == null)
            q.front = temp;
        else
            q.rear.next = temp;
        q.rear = temp;
        q.rear.next = q.front;
    }

    static int dequeue(queue q) {
        if (q.front == null) {
            System.out.println("Queue Empty");
            return Integer.MIN_VALUE;
        }
        int val;
        if (q.front == q.rear) {
            val = q.front.data;
            q.front = null;
            q.rear = null;
        } else {
            Node temp = q.front;
            val = temp.data;
            q.front = q.front.next;
            q.rear.next = q.front;
        }
        return val;
    }

    static void display(queue q) {
        Node temp = q.front;
        System.out.println();
        System.out.println("Elements: ");
        while (temp.next != q.front) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.front = q.rear = null;
        enqueue(q, 14);
        enqueue(q, 22);
        enqueue(q, 6);

        // Display elements present in Circular Queue
        display(q);

        // Deleting elements from Circular Queue
        System.out.printf("\nDeleted value = %d", dequeue(q));
        System.out.printf("\nDeleted value = %d", dequeue(q));

        // Remaining elements in Circular Queue
        display(q);

        enqueue(q, 9);
        enqueue(q, 20);
        display(q);
    }
}
