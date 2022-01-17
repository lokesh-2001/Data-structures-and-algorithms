// Find Maximum and Minimum number possible by doing at-most K swaps
public class kSwaps {
    static class result {
        String max = "";
        String min = "";
    }

    static void findMax(char arr[], int k, result r) {
        if (k == 0)
            return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[j] > arr[i]) {
                    char temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    String str = new String(arr);
                    if (r.max.compareTo(str) < 0)
                        r.max = str;
                    findMax(arr, k - 1, r);
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;

                }
            }
    }
    static void findMin(char arr[], int k, result r) {
        if (k == 0)
            return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[j] < arr[i]) {
                    char temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    String str = new String(arr);
                    if (r.min.compareTo(str) > 0)
                        r.min = str;
                    findMin(arr, k - 1, r);
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;

                }
            }
    }

    public static void main(String[] args) {
        String str = "129814999";
        result r = new result();
        r.max = str;
        r.min = str;
        findMax(str.toCharArray(),4, r);
        findMin(str.toCharArray(),4, r);
        System.out.println(r.max);
        System.out.println(r.min);
    }
}
