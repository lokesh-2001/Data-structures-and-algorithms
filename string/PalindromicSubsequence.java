// Count All Palindromic Subsequence in a given String.
// Find how many palindromic subsequences (need not necessarily be distinct) 
// can be formed in a given string. Note that the empty string is not considered 
// as a palindrome. 

// Input : str = "abcd"
// Output : 4
// Explanation :- palindromic  subsequence are : "a" ,"b", "c" ,"d" 

// Input : str = "aab"
// Output : 4
// Explanation :- palindromic subsequence are :"a", "a", "b", "aa"

public class PalindromicSubsequence {
    static int n;
    static int[][] dp = new int[1000][1000];
    static String str = "abcd";

    static int count(int i, int j) {
        if (i > j)
            return 0;
            
        if (dp[i][j] != -1)
            return dp[i][j];

        if (i == j)
            return dp[i][j] = 1;
        
        else if (str.charAt(i) == str.charAt(j))
            return dp[i][j] = count(i + 1, j) + count(i, j - 1) + 1 ;
        else
            return dp[i][j] = count(i + 1, j) + count(i, j - 1) - count(i + 1, j - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++)
            for (int j = 0; j < 1000; j++)
                dp[i][j] = -1;

        n = str.length();
        System.out.println("Total palindromic subsequence"
                + "are : " + count(0, n - 1));

    }
}
