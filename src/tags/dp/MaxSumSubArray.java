package tags.dp;

public class MaxSumSubArray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            if(dp[i] > max) max = dp[i];
        }

        return max;
    }
}
