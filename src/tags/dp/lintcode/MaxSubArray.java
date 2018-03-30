package tags.dp.lintcode;

public class MaxSubArray {
    // http://www.lintcode.com/zh-cn/problem/maximum-subarray/
    public int maxSubArray(int[] nums) {
        // write your code here
        int n = nums.length;

        int sum = nums[0];
        int max = sum;
        for(int i = 1; i < n; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            max = Math.max(sum, max);
        }

        return max;
    }
}
