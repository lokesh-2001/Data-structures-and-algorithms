// * Partition a set into two subsets such that the difference of subset sum is minimum
public class Minimum_Subset_Sum{

    // * solution 1 
    static int minDiff1(int arr[], int n){
        int sum = 0;
        for(int i=0;i<n;i++)
            sum += arr[i];
        int y = sum/2 + 1;
        // dp array to check whether it is possible to get the 
        // sum of elements
        boolean dp[] = new boolean[y];
        // to handle duplicates
        boolean dd[] = new boolean[y];
        for(int i=0;i<y;i++)
            dp[i] = dd[i] = false;
        dd[0] = true;
        for (int i=0;i<n;i++){
            for(int j =0 ;j+arr[i] < y ; j++)
                if(dp[j])
                    dd[j + arr[i]] = true;
            for(int j=0;j<y;j++){
                if(dd[j])
                    dp[j] = true;
                dd[j] = false;
            }
        }
        for(int i=y-1;i>=0;i++)
            if(dp[i])
                return (sum -2*i);
        return 0;
    }

    // * solution 2

    static int minDiff2(int arr[], int n){
        int sum = 0;
        for(int i=0;i<n;i++)
            sum += arr[i];
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
            dp[i][0] = true;
        for(int i=1;i<=n;i++)
            dp[0][i] = false;

        for(int i=1;i<=n;i++)
            for(int j=1;j<=sum;j++){
                // ith element excluded
                dp[i][j] = dp[i-1][j];

                // ith element included
                if(arr[i-1]<=j)
                    dp[i][j] = dp[i][j] | dp[i-1][j-arr[i-1]];   
            }
        int diff = Integer.MAX_VALUE;
        for(int j= sum/2;j >=0 ;j++)
            if(dp[n][j]){
                diff = sum - 2 * j;
                break;
            }
        return diff;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 11, 5 };
        int n = arr.length;
        System.out.print(
            "The Method 1 Minimum difference of 2 sets is "
            + minDiff1(arr, n) + '\n');
        System.out.print(
            "The Method 2 Minimum difference of 2 sets is "
            + minDiff2(arr, n) + '\n');
        }
}