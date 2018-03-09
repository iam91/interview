package lintcode.dp;

public class LCS {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here

        if(A == null || B == null || A.length() == 0 || B.length() == 0) return 0;

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = A.charAt(i - 1) == B.charAt(j - 1) ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }
}
