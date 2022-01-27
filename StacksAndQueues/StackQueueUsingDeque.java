public class StackQueueUsingDeque {

    // * IMPLEMENTING DEQUE
    // *DEQUE NODE
    static class dequeNode {
        int data;
        dequeNode next;
        dequeNode prev;
    }

    // *DEQUE IMPLEMENTATION
    static class deque {
        private dequeNode head;
        private dequeNode tail;

        public deque() {
            head = tail = null;
        }

        boolean isEmpty() {
            return head == null;
        }

        int size() {
            if (!isEmpty()) {
                dequeNode temp = head;
                int count = 0;
                while (temp != null) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
            return 0;
        }

        void insertHead(int d) {
            dequeNode temp = new dequeNode();
            temp.data = d;
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            } else {
                head.prev = temp;
                temp.next = head;
                temp.prev = null;
                head = temp;
            }
        }

        void insertLast(int d) {
            dequeNode temp = new dequeNode();
            temp.data = d;
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            } else {
                tail.next = temp;
                temp.next = null;
                temp.prev = tail;
                tail = temp;
            }
        }

        void removeHead() {
            if (!isEmpty()) {
                head = head.next;
                head.prev = null;
                return;
            }
            System.out.println("List Empty");
        }

        void removeLast() {
            if (!isEmpty()) {
                tail = tail.prev;
                tail.next = null;
                return;
            }
            System.out.println("List Empty");
        }

        void display() {
            dequeNode temp = head;
            if (!isEmpty()) {
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                return;
            }
            System.out.println("List Empty");
        }
    }

    // *IMPLEMENTING STACK USING DEQUE
    static class stack {
        deque d = new deque();

        public void push(int n) {
            d.insertLast(n);
        }

        public void pop() {
            d.removeLast();
        }

        public int size() {
            return d.size();
        }

        public void display() {
            d.display();
        }
    }

    // *IMPLEMENTING QUEUE USING DEQUE
    static class queue {
        deque d = new deque();

        public void push(int n) {
            d.insertLast(n);
        }

        public void pop() {
            d.removeHead();
        }

        public int size() {
            return d.size();
        }

        public void display() {
            d.display();
        }
    }

    public static void main(String[] args) {
        // *   STACK
        stack stk = new stack();
        // push 7 and 8 at top of stack
        stk.push(7);
        stk.push(8);
        System.out.print("Stack: ");
        stk.display();
        System.out.println();
        stk.pop();
        System.out.print("Stack: ");
        stk.display();
        System.out.println();

        // *   QUEUE 
        queue que = new queue();
        // Insert 12 and 13 in queue
        que.push(12);
        que.push(13);
        System.out.print("Queue: ");
        que.display();
        System.out.println();
        que.pop();
        System.out.print("Queue: ");
        que.display();
        System.out.println();


        System.out.println("Size of stack is " + stk.size());
        System.out.println("Size of queue is " + que.size());
    }
}
