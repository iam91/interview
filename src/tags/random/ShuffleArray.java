package tags.random;

import java.util.Random;

public class ShuffleArray {
    // https://leetcode.com/problems/shuffle-an-array/description/

    int[] nums;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] t = new int[this.nums.length];

        for(int i = 0; i < t.length; i++) t[i] = nums[i];

        Random rand = new Random();
        for(int i = t.length - 1; i > 0; i--) {
            int r = rand.nextInt(i + 1);

            int temp = t[r];
            t[r] = t[i];
            t[i] = temp;
        }

        return t;
    }
}
