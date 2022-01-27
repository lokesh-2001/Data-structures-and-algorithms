
// Design a Stack that supports getMin() in O(1) time and O(1) extra space.
import java.util.Stack;

public class getMin {
    static class getMinStack {
        Stack<Integer> st;
        Integer min;

        getMinStack() {
            st = new Stack<Integer>();
        }

        void getMin() {
            if (st.empty()) {
                System.out.println("Stack Empty");
                return;
            }
            System.out.println("Minium element : " + min);
        }

        void peek() {
            if (st.empty()) {
                System.out.println("Stack Empty");
                return;
            }
            Integer t = st.peek();
            System.out.print("Top Most Element : ");
            if (t < min)
                System.out.print(min);
            else
                System.out.print(t);
        }

        void pop() {
            if (st.empty()) {
                System.out.println("Stack Empty");
                return;
            }
            Integer t = st.pop();
            System.out.print("Top Most Element Removed : ");
            if (t < min) {
                System.out.print(min);
                min = 2 * min - t;
            } else
                System.out.print(t);
        }

        void push(Integer x) {
            if (st.empty()) {
                min = x;
                st.push(x);
                System.out.println("Number Inserted : " + x);
                return;
            }
            if (x < min) {
                st.push(2 * x - min);
                min = x;
            } else
                st.push(x);
            System.out.println("Number Inserted : " + x);
        }
    }
    public static void main(String[] args) {
        getMinStack st = new getMinStack();
        st.push(3);
        System.out.println();
        st.push(5);
        System.out.println();
        st.getMin();
        System.out.println();
        st.push(2);
        System.out.println();
        st.push(1);
        System.out.println();
        st.getMin();
        System.out.println();
        st.pop();
        System.out.println();
        st.getMin();
        System.out.println();
        st.pop();
        System.out.println();
        st.peek();
    }
}
