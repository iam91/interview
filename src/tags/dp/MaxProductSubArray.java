package tags.dp;

public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];


        dp1[0] = nums[0];
        dp2[0] = nums[0];
        int max = nums[0];

        for(int i = 1; i < n; i++) {
            dp1[i] = Math.max(Math.max(nums[i], dp1[i - 1] * nums[i]), dp2[i - 1] * nums[i]);
            dp2[i] = Math.min(Math.min(nums[i], dp2[i - 1] * nums[i]), dp1[i - 1] * nums[i]);
            if(dp1[i] > max) max = dp1[i];
        }

        return max;
    }
}
