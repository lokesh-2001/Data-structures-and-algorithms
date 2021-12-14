// Minimum swaps required to bring all elements 
// less than or equal to k together
public class KElementsTogeteher {
    static int minSwaps(int arr[], int n, int k) {
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (arr[i] <= k)
                ++count;
        int unwanted = 0;
        for (int i = 0; i < count; ++i)
            if (arr[i] > k)
                ++unwanted;
        int ans = unwanted;
        for (int i = 0, j = count; j < n; ++i, ++j) {
            if (arr[i] > k)
                --unwanted;
            if (arr[j] > k)
                ++unwanted;
            ans = Math.min(ans, unwanted);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 3};
        int n = arr.length;
        int k = 3;
        System.out.print(minSwaps(arr, n, k) + "\n");
    }
}
