
// Sort a Stack using recursion
import java.util.Stack;
import java.util.ListIterator;

public class SortStack {

    // * In ascending order
    static void sortedInsertionAscen(Stack<Integer> st, int n) {
        if (st.isEmpty() || n > st.peek()) {
            st.push(n);
            return;
        }
        int x = st.pop();
        sortedInsertionAscen(st, n);
        st.push(x);
    }

    static void sortAscen(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sortAscen(s);
            sortedInsertionAscen(s, x);
        }
    }

    static void printStack(Stack<Integer> s) {
        ListIterator<Integer> it = s.listIterator();
        while (it.hasNext())
        System.out.print(it.next() + " ");
        //     it.next();
        // while (it.hasPrevious())
    }

        // * In descending order
        static void sortedInsertionDescen(Stack<Integer> st, int n) {
            if (st.isEmpty() || n < st.peek()) {
                st.push(n);
                return;
            }
            int x = st.pop();
            sortedInsertionDescen(st, n);
            st.push(x);
        }
        static void sortDescen(Stack<Integer> s) {
            if (!s.isEmpty()) {
                int x = s.pop();
                sortDescen(s);
                sortedInsertionDescen(s, x);
            }
        }
    
    
    public static void main(String[] args) {
        //* In ascending order
        System.out.println("In ascending order");
        System.out.println();
        Stack<Integer> s1 = new Stack<>();
        s1.push(30);
        s1.push(-5);
        s1.push(18);
        s1.push(14);
        s1.push(-3);
        System.out.println("Stack elements before sorting: ");
        printStack(s1);

        sortAscen(s1);

        System.out.println(" \n\nStack elements after sorting:");
        printStack(s1);

        System.out.println();
        //* In descending order
        System.out.println("In descending order");
        System.out.println();
        Stack<Integer> s2 = new Stack<>();
        s2.push(30);
        s2.push(-5);
        s2.push(18);
        s2.push(14);
        s2.push(-3);
        System.out.println("Stack elements before sorting: ");
        printStack(s2);

        sortDescen(s2);

        System.out.println(" \n\nStack elements after sorting:");
        printStack(s2);
    
    
    }
}