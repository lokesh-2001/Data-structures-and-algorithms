
// Find next greater number with same set of digits. [Very Very IMP]
// Given a number n, find the smallest number that has same set of digits as n 
// and is greater than n. If n is the greatest possible number with its set of digits, 
// then print "not possible".
import java.util.Arrays;

public class nextGreaterNumberWithSameSetOfDigits {
    static void swap(char arr[], int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void findNext(char arr[], int n) {
        int i;
        for (i = n - 1; i > 0; i--)
            if (arr[i] > arr[i - 1])
                break;
        if (i == 0) // digits are in descending order
            System.out.println("Not Possible");
        else {
            int x = arr[i - 1], min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > x && arr[j] < arr[min])
                    min = j;
            }
            swap(arr, i - 1, min);
            Arrays.sort(arr, i, n);

            System.out.print("Next Number: ");
            for (int k = 0; k < n; k++)
                System.out.print(arr[k]);
        }
    }

    public static void main(String[] args) {
        char digits[] = { '5', '3', '4', '9', '7', '6' };
        int n = digits.length;
        findNext(digits, n);

    }
}
