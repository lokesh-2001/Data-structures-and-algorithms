public class Count_Subset_sum{
    static int CountSubsetSum(int arr[], int w, int n){
        // initialization
        int dp[][] = new int[n+1][w+1];
        for (int i=0;i<n+1;i++)
            for (int j=0;j<w+1;j++){
                if(i==0)
                    dp[i][j] = 0;
                if(j==0)
                    dp[i][j] = 1;
            }
        for (int i=1;i<n+1;i++)
            for (int j=1;j<w+1;j++){
                if(arr[i-1]<=j)
                    dp[i][j] =   dp[i-1][j] + dp[i-1][j - arr[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        return dp[n][w];
    }
    public static void main(String[] args) {
        int arr[] = {2,3,7,8,10,1,9};
        int n = arr.length;
        int w= 11;
        System.out.println(CountSubsetSum(arr, w, n));
    }
}