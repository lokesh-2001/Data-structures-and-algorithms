
// Sum of minimum and maximum elements of all subarrays of size 'k'.
import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinAndMaxInASubarray {
    static int sum(int arr[], int k) {
        int sum = 0;
        // in 'd' increasing decreasing order of values from front to rear
        // in 'g' maintain decreasing order of values from front to rear
        Deque<Integer> d = new LinkedList<>();
        Deque<Integer> g = new LinkedList<>();
        int i = 0;
        for (; i < k; i++) {
            while (!d.isEmpty() && arr[d.peekLast()] >= arr[i])
                d.removeLast();
            while (!g.isEmpty() && arr[g.peekLast()] <= arr[i])
                g.removeLast();
            g.addLast(i);
            d.addLast(i);
        }

        for (; i < arr.length; i++) {
            sum += arr[d.peekFirst()] + arr[g.peekFirst()];
            while (!d.isEmpty() && d.peekFirst() <= i-k)
                d.removeFirst();
            while (!g.isEmpty() && g.peekFirst() <= i-k)
                g.removeFirst();
            while(!d.isEmpty() && arr[d.peekLast()] >= arr[i])
                d.removeLast();
            while(!g.isEmpty() && arr[g.peekLast()] <= arr[i])
                g.removeLast();
            g.addLast(i);
            d.addLast(i);    
        }

        sum += arr[d.peekFirst()] + arr[g.peekFirst()];
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {2, 5, -1, 7, -3, -1, -2} ;
        System.out.println(sum(arr, 3));
    }
}
