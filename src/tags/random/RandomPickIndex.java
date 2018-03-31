package tags.random;

import java.util.Random;

public class RandomPickIndex {
    // https://leetcode.com/problems/random-pick-index/description/

    int[] nums;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int n = this.nums.length;
        Random rand = new Random();
        int r = -1;
        int t = 0;
        for(int i = 0; i < n; i++) {
            if(target == this.nums[i]) {
                t++;
                r = rand.nextInt(t) == 0 ? i : r;
            }
        }

        return r;
    }
}
