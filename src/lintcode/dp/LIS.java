package lintcode.dp;

public class LIS {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = 1;
        int ret = 1;
        for(int i = 0; i < n; i++) {
            int max = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[j] + 1 > max) max = dp[j] + 1;
                }
            }
            dp[i] = max;
            if(max > ret) ret = max;
        }

        return ret;
    }
}
