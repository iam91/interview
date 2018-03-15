package tags.dp;


public class BackPack {
    // http://www.lintcode.com/zh-cn/problem/backpack/
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here

        if(A == null || A.length == 0 || m == 0) return 0;

        int n = A.length;
        int[][] dp = new int[n][m + 1];

        for(int j = A[0]; j <= m; j++) dp[0][j] = A[0];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                if(A[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i]] + A[i]);
                }
            }
        }

        return dp[n - 1][m];
    }

    public static void main(String[] args) {
        BackPack c = new BackPack();
        int[] n = {3,4,8,5};
        System.out.println(c.backPack(10, n));
    }
}
