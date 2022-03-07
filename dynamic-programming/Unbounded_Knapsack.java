public class Unbounded_Knapsack {
    static int max(int a, int b){    
        return (a > b) ? a : b;    
    }
    static int UnboundedKnapsack(int w, int wt[], int n) {
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
                    dp[i][j] = max(dp[i][j - wt[i - 1]] , dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }
  
}
