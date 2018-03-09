package leetcode.array;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2) return false;

        int n = nums.length;
        int[] acc = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            acc[i] = nums[i - 1] + acc[i - 1];
        }

        for(int i = 2; i <= n; i++) {
            for(int j = i - 2; j >= 0; j--) {
                int sum = acc[i] - acc[j];
                if(k == 0 && (sum == 0)) return true;
                if(k != 0 && (sum % k == 0)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum c = new ContinuousSubarraySum();

        int[] nums = {0,0}; int k = 0;

        System.out.println(c.checkSubarraySum(nums, k));
    }
}
