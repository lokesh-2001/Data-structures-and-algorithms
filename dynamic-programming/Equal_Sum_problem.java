// given an array print whether the array can be divided in two subsets having equal sums 
public class Equal_Sum_problem {
    static boolean EqualSum(int arr[], int n){
        int sum=0;
        for (int i=0;i<n;i++)
            sum += arr[i];
        System.out.println(sum);
        if (sum%2!=0)
            return false;
        return SubsetSum(arr, sum/2, n);
        
    }
    static boolean SubsetSum(int arr[], int w, int n){
        // initialization
        boolean dp[][] = new boolean[n+1][w+1];
        for (int i=0;i<n+1;i++)
            for (int j=0;j<w+1;j++){
                if(i==0)
                    dp[i][j] = false;
                if(j==0)
                    dp[i][j] = true;
            }
        for (int i=1;i<n+1;i++)
            for (int j=1;j<w+1;j++){
                if(arr[i-1]<=j)
                    dp[i][j] = dp[i][j - arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        return dp[n][w];
    }
    public static void main(String[] args) {
        int arr[] = {1,5,11,5};
        int n = arr.length;
        System.out.println(EqualSum(arr,  n));
    }

}
