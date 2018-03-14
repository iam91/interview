package tags.dp;

public class LCCS {
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || A.length() == 0 || B == null || B.length() == 0)
            return 0;

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n][m];

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(A.charAt(i) == B.charAt(j)) {
                    if(i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if(dp[i][j] > max) max = dp[i][j];
            }
        }

        return max;
    }
}
