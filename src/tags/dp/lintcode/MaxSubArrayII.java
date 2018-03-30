package tags.dp.lintcode;

import java.util.List;
import java.util.LinkedList;

public class MaxSubArrayII {
    // http://www.lintcode.com/zh-cn/problem/maximum-subarray-ii/
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int n = nums.size();

        int sum1 = nums.get(0);
        int sum2 = nums.get(1);

        int max = nums.get(0) + nums.get(1);

        for(int i = 0; i < n - 1; i++) {

            if(i > 0)
                sum1= sum1 > 0 ? sum1 + nums.get(i) : nums.get(i);
            sum2 = nums.get(i + 1);
            max = Math.max(max, sum1 + sum2);

            for(int j = i + 2; j < n; j++) {
                sum2 = sum2 > 0 ? sum2 + nums.get(j) : nums.get(j);
                max = Math.max(max, sum1 + sum2);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSubArrayII c = new MaxSubArrayII();

        int[] nums = {-1,-2,-3,-100,-1,-50};
        List<Integer> ns = new LinkedList<>();
        for(int n: nums) ns.add(n);

        System.out.println(c.maxTwoSubArrays(ns));
    }
}
