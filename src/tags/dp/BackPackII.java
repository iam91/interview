package tags.dp;

public class BackPackII {
    // http://www.lintcode.com/zh-cn/problem/backpack-ii/
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int n = A.length;

        int[][] dp = new int[n][m + 1];

        for(int i = A[0]; i <= m; i++) dp[0][i] = V[0];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j < A[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i]] + V[i]);
            }
        }

        return dp[n - 1][m];
    }
}
