package tags.dp;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;

        int[] dp = new int[n];

        int ret = 1;
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if(dp[i] > ret) ret = dp[i];
        }

        return ret;
    }
}
