package tags.dp;

public class TargetSum {
    // https://leetcode.com/problems/target-sum/description/
    public int findTargetSumWays(int[] nums, int S) {
        if(S > 1000) return 0;
        int n = nums.length;

        int MAXSUM = 1000;

        int[][] dp = new int[n][MAXSUM * 2 + 1];
        dp[0][MAXSUM + nums[0]] += 1;
        dp[0][MAXSUM - nums[0]] += 1;

        for(int i = 1; i < n; i++) {
            for(int j = -MAXSUM; j <= MAXSUM; j++) {
                if(dp[i - 1][j + MAXSUM] > 0) {
                    dp[i][MAXSUM + j - nums[i]] += dp[i - 1][MAXSUM + j];
                    dp[i][MAXSUM + j + nums[i]] += dp[i - 1][MAXSUM + j];
                }
            }
        }

        return dp[n - 1][MAXSUM + S];
    }
}
