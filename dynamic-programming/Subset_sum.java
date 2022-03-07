// given an array print whether their is a subset with sum equal to the given sum 
public class Subset_sum {
    
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
        int arr[] = {2,3,7,8,10};
        int n = arr.length;
        int w= 11;
        System.out.println(SubsetSum(arr, w, n));
    }
}
