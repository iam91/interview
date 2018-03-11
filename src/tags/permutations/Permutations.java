package tags.permutations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        // return iter(nums);
        return recur(nums, 0, nums.length - 1);
    }

    private List<List<Integer>> recur(int[] nums, int l, int r) {
        List<List<Integer>> ret = new LinkedList<>();
        if(nums == null || nums.length == 0) return ret;

        if(l == r) {
            List<Integer> perm = new LinkedList<>();
            for(int nn: nums) perm.add(nn);
            ret.add(perm);
            return ret;
        }

        for(int i = l; i <= r; i++) {
            swap(nums, l, i);
            ret.addAll(recur(nums, l + 1, r));
            swap(nums, l, i);
        }
        return ret;
    }

    private List<List<Integer>> iter(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        if(nums == null || nums.length == 0) return ret;

        Arrays.sort(nums);
        boolean work = true;
        int n = nums.length;

        do {
            List<Integer> perm = new LinkedList<>();
            for(int nn: nums) perm.add(nn);
            ret.add(perm);

            int i = n - 1, j = n - 1;
            while(i > 0) {
                if(nums[i - 1] < nums[i]) {
                    while(j >= i) {
                        if(nums[j] > nums[i - 1]) {
                            swap(nums, j, i - 1);
                            break;
                        }
                        j--;
                    }
                    break;
                }
                i--;
            }
            if(i == 0) work = false;

            j = n - 1;
            while(i < j) swap(nums, j--, i++);
        } while(work);

        return ret;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
