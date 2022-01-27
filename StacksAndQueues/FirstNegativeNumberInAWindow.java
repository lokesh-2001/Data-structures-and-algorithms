
// First negative integer in every window of size 'k'
import java.util.LinkedList;

public class FirstNegativeNumberInAWindow {
    // * Method 1
    // * Time Complexity: O(n)
    // * Auxiliary Space: O(k)

    static void firstNegative1(int arr[], int k, int n) {
        LinkedList<Integer> d = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++)
            if (arr[i] < 0)
                d.add(i);
        for (; i < n; i++) {
            if (!d.isEmpty())
                System.out.print(arr[d.peek()] + " ");
            else
                System.out.print("0" + " ");

            while (!d.isEmpty() && d.peek() < (i - k + 1))
                d.remove();
            if (arr[i] < 0)
                d.add(i);
        }
        if (!d.isEmpty())
            System.out.print(arr[d.peek()] + " ");
        else
            System.out.print("0" + " ");

    }

    // * Method 2
    // * Time Complexity: O(n)
    // * Auxiliary Space: O(1)
    static void firstNegative2(int arr[], int k, int n) {
        int firstIndex = 0;
        int firstElem = 0;
        for (int i = k - 1; i < n; i++) {
            while (firstIndex < i &&
                    (firstIndex <= i - k || arr[firstIndex] > 0))
                firstIndex++;
            if (arr[firstIndex] < 0)
                firstElem = arr[firstIndex];
            else
                firstElem = 0;
            System.out.print(firstElem + " ");
        }
    }

    public static void main(String[] args) {
        int arr1[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int arr2[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        System.out.println("Method 1");
        firstNegative1(arr1, 3, arr1.length);
        System.out.println();
        System.out.println("Method 2");
        firstNegative2(arr2, 3, arr2.length);
    }
}
