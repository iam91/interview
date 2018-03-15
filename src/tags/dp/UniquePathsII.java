package tags.dp;

public class UniquePathsII {
    // https://leetcode.com/problems/unique-paths-ii/description/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = 1 - obstacleGrid[0][0];
        for(int i = 1; i < n; i++) {
            dp[0][i] = obstacleGrid[0][i] == 0 ? dp[0][i - 1] : 0;
        }
        for(int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 0 ? dp[i - 1][0] : 0;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {

                if(obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII c = new UniquePathsII();

        int[][] obs = {{0, 1}};

        System.out.println(c.uniquePathsWithObstacles(obs));
    }
}
