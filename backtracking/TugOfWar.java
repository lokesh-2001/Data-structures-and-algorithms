// Given a set of n integers, divide the set in two subsets of 
// n/2 sizes each such that the difference of the sum of two subsets 
// is as minimum as possible. If n is even, then sizes of two subsets 
// must be strictly n/2 and if n is odd, then size of one subset must 
// be (n-1)/2 and size of other subset must be (n+1)/2.

public class TugOfWar {
    static int minDiff;

    // x is the no of items selected
    static void util(int arr[], int n, boolean curr[], int x, boolean sol[], int sum, int currSum, int currPos) {
        if (currPos == n)
            return;
        // check if that the no of elements left are not less than the no of elements
        // required to form the sol
        if ((n / 2 - x) > n - currPos)
            return;
        util(arr, n, curr, x, sol, sum, currSum, currPos + 1);
        x++;
        currSum += arr[currPos];
        curr[currPos] = true;

        if (x == n / 2) {
            if (Math.abs(sum / 2 - currSum) < minDiff) {
                minDiff = Math.abs(sum / 2 - currSum);
                for (int i = 0; i < n; i++)
                    sol[i] = curr[i];
            }
        } else {
            util(arr, n, curr, x, sol, sum, currSum, currPos + 1);
        }
        curr[currPos] = false;
    }

    static void base(int arr[]) {
        int n = arr.length;
        boolean[] curr = new boolean[n];
        boolean[] sol = new boolean[n];
        minDiff = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            curr[i] = sol[i] = false;
        }
        util(arr, n, curr, 0, sol, sum, 0, 0);
        System.out.print("The first subset is: ");
        for (int i = 0; i < n; i++) {
            if (sol[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.print("\nThe second subset is: ");
        for (int i = 0; i < n; i++) {
            if (sol[i] == false)
                System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {23, 45, -34, 12, 0, 98,
            -99, 4, 189, -1, 4};
        base(arr);
    }
}
