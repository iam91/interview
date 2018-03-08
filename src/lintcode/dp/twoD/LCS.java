package lintcode.dp.twoD;

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

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            dp[i][0] = A.charAt(i) == B.charAt(0) ? 1 : 0;
        }
        for(int i = 0; i < m; i++) {
            dp[0][i] = A.charAt(0) == B.charAt(i) ? 1 : 0;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                dp[i][j] = A.charAt(i) == B.charAt(j) ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }
}
