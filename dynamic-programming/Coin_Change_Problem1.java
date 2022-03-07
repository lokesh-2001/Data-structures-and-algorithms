// * Coin Change problem # 1 
// * find the max number of ways in which a group of coins can add to a particular sum 
// Given a value N, if we want to make change for N cents, and we have infinite supply of 
// each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The 
// order of coins doesn't matter.
// For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},
// {2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five 
// solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
public class Coin_Change_Problem1 {
    static int CoinChangeMax(int w, int wt[], int n) {
        int i, j;
        int dp[][] = new int[n + 1][w + 1];
        for (i = 0; i < n + 1; i++) {
            for (j = 0; j < w + 1; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j==0)
                    dp[i][j] = 1;
            }
        }
        for (i = 1; i < n + 1; i++) {
            for (j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j)
                    dp[i][j] = dp[i][j - wt[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(CoinChangeMax(5,arr,arr.length));
    }
}
