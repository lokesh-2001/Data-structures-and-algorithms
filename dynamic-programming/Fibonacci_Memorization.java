public class Fibonacci_Memorization{
    int NILL;
    int dp[];
    Fibonacci_Memorization(int MAX){
        NILL = -1;
        dp = new int[MAX];
        int i;
        for(i=0;i<MAX;i++)
            dp[i] = NILL;
        
    }
    int fibo(int n){
        if(this.dp[n] == this.NILL){
            if(n<=1)
                this.dp[n] = n;
            else
                this.dp[n] = fibo(n-1) + fibo(n-2);
        }
        return this.dp[n];
    } 
    public static void main(String [] args){
        Fibonacci_Memorization obj = new Fibonacci_Memorization(15);
        System.out.println(obj.fibo(5));
    }
}