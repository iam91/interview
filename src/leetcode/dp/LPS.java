package leetcode.dp;

public class LPS {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) dp[i][i] = 1;

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j)
                        ? (i + 1 == j ? 2 : dp[i + 1][j - 1] + 2)
                        : Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }
}
