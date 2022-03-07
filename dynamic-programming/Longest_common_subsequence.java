public class Longest_common_subsequence{
    static String s1="AGGTAB";
    static String s2="GXTXAYB";

    //  * recursive approach
    static int recursive(char[] x, char[] y, int n, int m){
        if(n==0 || m==0)
            return 0;
        if(x[n-1] == y[m-1])
            return 1+  recursive(x, y, n-1, m-1);
        return   Math.max(recursive(x, y, n-1, m),recursive(x, y, n, m-1));
    }

    // * Memorization approach
    static int memBase(char[] x, char[] y){
        int dpMem[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=x.length;i++)
            for(int j=0;j<=y.length;j++)
                dpMem[i][j] = -1;
        return memorization(x, y, x.length, y.length,dpMem);
    }
    static int memorization(char[] x, char[] y, int n, int m, int dp[][]){
        if(n==0 || m==0)
            return 0;
        
        if(dp[n][m] != -1)
            return dp[n][m];

        if(x[n-1] == y[m-1])
            return 1+  memorization(x, y, n-1, m-1,dp);
        return   Math.max(memorization(x, y, n-1, m,dp),memorization(x, y, n, m-1,dp));
    }

    // * Tabular Approach
    static int tabulization(char[] x, char[] y, int n, int m){
        int dpTabular[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++)       
            for(int j=0;j<m+1;j++)
                if(j==0 || i==0)
                    dpTabular[i][j] = 0;    
        
        for(int i=1;i<n+1;i++){       
            for(int j=1;j<m+1;j++){
                if(x[i-1] == y[j-1])
                    dpTabular[i][j] = 1+  tabulization(x, y, i-1, j-1);
                else
                dpTabular[i][j] = Math.max(tabulization(x, y, i-1, j),tabulization(x, y, i, j-1));
            }
        }        
        return dpTabular[n][m];
    }
    public static void main(String[] args) {
        System.out.println(recursive(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println(memBase(s1.toCharArray(), s2.toCharArray()));
        System.out.println(tabulization(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    }
}