package tags.permutations;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
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

            // duplication removal
            Arrays.sort(nums, l, r + 1);
            if(i < r && nums[i] == nums[i + 1]) continue;

            swap(nums, i, l);
            List<List<Integer>> perm = recur(nums, l + 1, r);
            ret.addAll(perm);
            swap(nums, i, l);
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
            while(i < j) {
                swap(nums, j--, i++);
            }
        } while(work);

        return ret;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        PermutationsII c = new PermutationsII();

        int[] n = {1,1,2,2};

        List<List<Integer>> r = c.permuteUnique(n);

        int a = 0;
    }
}
