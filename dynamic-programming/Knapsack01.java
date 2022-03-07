public class Knapsack01{
    static int max(int a, int b){    
        return (a > b) ? a : b;    
    }
    // * Method 1 using memoization
    static int knapSackRec1(int W, int wt[],int val[], int n,int [][]dp){  
        if (n == 0 || W == 0)  
            return 0;
             
        if (dp[n][W] != -1)
            return dp[n][W];  
         
        if (wt[n - 1] > W)  
            return dp[n][W] = knapSackRec1(W, wt, val,n - 1, dp);
        else
            return dp[n][W] = max((val[n - 1] + knapSackRec1(W - wt[n - 1], wt,val, n - 1, dp)),
                                  knapSackRec1(W, wt, val,n - 1, dp));            
    }
     
    static int knapSack1(int W, int wt[], int val[], int N){ 
        int dp[][] = new int[N + 1][W + 1];
        for(int i = 0; i < N + 1; i++)  
            for(int j = 0; j < W + 1; j++)  
                dp[i][j] = -1;            
        return knapSackRec1(W, wt, val, N, dp);    
    }
     

    // * Method 2 using TopDown DP
    static int knapSack2(int w, int wt[], int val[], int n){
        int i,j;
        int dp[][] = new int[n+1][w+1];
        for (i=0;i<n+1;i++)
            for (j=0;j<w+1;j++)
                if(i==0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i-1] <= j)
                    dp[i][j] = max(val[i-1] + dp[i-1][j-wt[i-1]] , dp[i-1][j]);
                else
                    dp[i][j]=dp[i-1][j];        
        return dp[n][w];
    }

    public static void main(String [] args)
    {      
        int val[] = { 60, 100, 120 };  
        int wt[] = { 10, 20, 30 };  
         
        int W = 50; 
        int N = val.length;        
         
        System.out.println(knapSack1(W, wt, val, N));  
        System.out.println(knapSack2(W, wt, val, N));  
    } 
}