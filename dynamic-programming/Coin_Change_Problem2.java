// * Coin Change problem # 2 
// * find the min number of coins required to form a given sum
// ! This problem requires an extra step of initialization (i.e.) initialization of 2nd row 
public class Coin_Change_Problem2 {
    
    static int min(int a, int b){    
        return (a > b) ? b : a;    
    }

    static int CoinChangeMin(int w, int wt[], int n) {
        int i, j;
        int dp[][] = new int[n + 1][w + 1];
        // * initialization of 1st row and 1st col
        for (i = 0; i < n + 1; i++) {
            for (j = 0; j < w + 1; j++) {
                if (i == 0)
                    dp[i][j] = Integer.MAX_VALUE - 1 ; 
                if (j==0)
                    dp[i][j] = 0;
            }
        }
    
        // * initialization of 2nd row 
            for(j=1;j<w+1;j++){
                if(j%wt[0] == 0)
                    dp[1][j] = j/wt[0];
                else
                    dp[1][j] = Integer.MAX_VALUE - 1;
            }

        // * finding the solution
        for (i = 2; i < n + 1; i++) {
            for (j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j)
                    dp[i][j] = min( 1 + dp[i][j - wt[i - 1]] , dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(CoinChangeMin(5,arr,arr.length));

    }
}
