// count the number of subsets which can be formed by adding the sum of the subsets of the array
// before each element of the array only 2 signs can be appended i.e. +/-
// e.g. 1 1 2 3 is given array sum is 1
// the count is 3
// the subsets are
// +1 -1 -2 +3 
// -1 +1 -2 +3 
// +1 +1 +2 -3 
public class Target_Sum {

    static int CountSubsetSum(int arr[], int w, int n){
        int sum=0;
        for (int i=0;i<n;i++)
            sum += arr[i];
        if(w< -sum || w> sum)
            return 0;
        // initialization
        int dp[][] = new int[n+1][sum*2+1];
        // for (int i=0;i<n+1;i++)
        //     for (int j=0;j<sum*2+1;j++){
        //         if(i==0)
        //             dp[i][j] = 0;
        //         if(j==0)
        //             dp[i][j] = 1;
        //     }
        dp[0][sum] = 1;
        for (int i=1;i<n+1;i++)
            for (int j=0;j<sum*2+1;j++){
                if(j+arr[i-1]<sum*2+1)
                    dp[i][j] =   dp[i][j] + dp[i-1][j + arr[i-1]];
                if(j-arr[i-1]>=0)
                    dp[i][j] =  dp[i][j] + dp[i-1][j - arr[i-1]];
            }
        return dp[n][sum+w];
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,3};
        int n = arr.length;
        int w= 1;
        System.out.println(CountSubsetSum(arr, w, n));
    }
}
