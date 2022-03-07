// count the total number of subsets with given diff
public class Count_No_Of_Subsets_with_given_diff {
    static int util(int arr[], int n, int diff){
        int sum=0;
        for(int i=0;i<n;i++)
            sum += arr[i];
        int s1 = (diff + sum)/2;
         return CountSubsetSum(arr,s1,n);

    } 
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
        int arr[] = {1,1,2,3};
        int n = arr.length;
        int diff= 1;
        System.out.println(util(arr, n, diff));

    }
}
   