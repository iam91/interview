package tags.dp;

public class LCS {
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || A.length() == 0 || B == null || B.length() == 0) return 0;

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n][m];

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = A.charAt(i) == B.charAt(j) ? 1 : 0;
                } else {
                    dp[i][j] = A.charAt(i) == B.charAt(j) ? dp[i - 1][j - 1] + 1
                            : Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if(dp[i][j] > max) max = dp[i][j];
            }
        }

        return max;
    }
}
