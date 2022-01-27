public class queue {
    private int size;
    private int arr[];
    private int front, rear;

    queue(int n) {
        size = n;
        arr = new int[n];
        front = rear = -1;
    }

    boolean isFull() {
        return (front == 0 && rear == size - 1);
    }

    boolean isEmpty() {
        return (front == -1);
    }

    void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue Overflow!!");
            return;
        }
        if (front == -1)
            front = 0;
        System.out.println("Inserting : " + x);
        rear++;
        arr[rear] = x;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!!");
            return -1;
        }
        int d = arr[front];
        // if queue contains only one element
        if (front >= rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        System.out.println("Deleting : " + d);
        return d;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        System.out.println();
        for (int i = front; i <=rear; i++){
            if(i!=rear)
                System.out.print(arr[i] + "<-");
            else
                System.out.print(arr[i]);
        }
        // System.out.print(++rear);
        System.out.println();

    }

    public static void main(String[] args) {
        queue q = new queue(5);
        q.dequeue();
        for (int i = 1; i < 6; i++) {
            q.enqueue(i);
        }
        q.enqueue(6);
        q.display();
        q.dequeue();
        q.display();
    }
}
