public class Fibonacci_Tabulation{
    int NILL;
    int dp[];
    Fibonacci_Tabulation(int MAX){
        NILL = -1;
        dp = new int[MAX];
        int i;
        for(i=0;i<MAX;i++)
            dp[i] = NILL;
        
    }
    int fibo(int n){
        dp[1] = 1;
        dp[0] = 0;
        for (int i=2;i<=n;i++)
            dp[i] = dp[i-1] + dp[i-2];
        return this.dp[n];
    } 
    public static void main(String [] args){
        Fibonacci_Tabulation obj = new Fibonacci_Tabulation(15);
        System.out.println(obj.fibo(5));
    }
}