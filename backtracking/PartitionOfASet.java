// Partition of a set into K subsets with equal sum
public class PartitionOfASet {
    // array - given input array
    // subsetSum array - sum to store each subset of the array
    // taken - boolean array to check whether element
    // is taken into sum partition or not
    // K - number of partitions needed
    // N - total number of element in array
    // currIndex - current subsetSum index
    // LimitIndex - lastIdx from where array element should
    // be taken
    static boolean util(int arr[], int subsetSum[], boolean taken[], int subset, int K, int N, int currIndex,
            int LimitIndex) {

        if (subsetSum[currIndex] == subset) {
            if (currIndex == K - 2)
                return true;
            return util(arr, subsetSum, taken, subset, K, N, currIndex + 1, N - 1);
        }
        for (int i = LimitIndex; i >= 0; i--) {
            if (taken[i])
                continue;
            int temp = subsetSum[currIndex] + arr[i];
            if (temp <= subset) {
                taken[i] = true;
                subsetSum[currIndex] += arr[i];
                boolean next = util(arr, subsetSum, taken, subset, K, N, currIndex, i - 1);
                taken[i] = false;
                subsetSum[currIndex] -= arr[i];
                if (next)
                    return true;
            }
        }
        return false;
    }

    static boolean base(int arr[], int N, int K) {
        if (K == 1)
            return true;
        if (N < K)
            return false;
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += arr[i];
        if (sum % K != 0)
            return false;

        int subset = sum / K;
        int[] subsetSum = new int[K];
        boolean[] taken = new boolean[N];

        for (int i = 0; i < K; i++)
            subsetSum[i] = 0;
        for (int i = 0; i < N; i++)
            taken[i] = false;
        subsetSum[0] = arr[N - 1];
        taken[N - 1] = true;

        return util(arr, subsetSum, taken, subset, K, N, 0, N - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 5, 3, 3 };
        int N = arr.length;
        int K = 3;

        if (base(arr, N, K))
            System.out.println("Partitions into equal sum is possible.");
        else
            System.out.println("Partitions into equal sum is not possible.");

    }
}
