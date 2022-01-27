// Implement a Circular queue
// * ARRAY IMPLEMENTATION
import java.util.ArrayList;

public class CircularQueueArray {
    int size, front, rear;
    ArrayList<Integer> q = new ArrayList<Integer>();

    CircularQueueArray(int n) {
        size = n;
        front = rear = -1;
    }

    void enqueue(int d) {
        if ((front == 0 && rear == size - 1) ||
                (rear == (front - 1) % (size - 1))) {
            System.out.println("Queue Full");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
            q.add(rear, d);
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            q.set(rear, d);
        } else {
            rear += 1;
            if (front <= rear)
                q.add(rear, d);
            else
                q.set(rear, d);
        }
    }

    int dequeue() {
        int temp;
        if (front == -1) {
            System.out.println("Queue is Empty");
            return -1;
        }
        temp = q.get(front);
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1)
            front = 0;
        else
            front += 1;
        return temp;
    }

    void display() {
        if (front == -1) {
            System.out.println("Queue Empty!!");
            return;
        }
        System.out.println();
        System.out.println("Elements ");
        if (rear >= front)
            for (int i = front; i <= rear; i++)
                System.out.print(q.get(i) + " ");

        else {
            for (int i = front; i < size; i++)
                System.out.print(q.get(i) + " ");
            for (int i = 0; i <= rear; i++)
                System.out.print(q.get(i) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueueArray q = new CircularQueueArray(5);

        q.enqueue(14);
        q.enqueue(22);
        q.enqueue(13);
        q.enqueue(-6);

        q.display();

        int x = q.dequeue();

        // Checking for empty queue.
        if (x != -1) {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        x = q.dequeue();

        // Checking for empty queue.
        if (x != -1) {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        q.display();

        q.enqueue(9);
        q.enqueue(20);
        q.enqueue(5);

        q.display();

        q.enqueue(20);
    }
}
