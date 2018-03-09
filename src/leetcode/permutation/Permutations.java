package leetcode.permutation;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        // return permuteIter(nums);
        return permuteRecur(nums);
    }

    private List<List<Integer>> permuteRecur(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();

        List<Integer> remain = new LinkedList<>();
        for(Integer i: nums) {
            remain.add(i);
        }

        return recurHelper(remain);
    }

    private List<List<Integer>> recurHelper(List<Integer> remain) {
        List<List<Integer>> ret = new LinkedList<>();

        if(remain.size() == 0) return ret;

        for(Integer val: remain.toArray(new Integer[0])) {
            remain.remove(val);

            List<List<Integer>> t = recurHelper(remain);
            if(t.size() == 0) {
                List<Integer> per = new LinkedList<>();
                per.add(val);
                t.add(per);
            } else {
                for(List<Integer> per: t) {
                    per.add(val);
                }
            }
            ret.addAll(t);

            remain.add(val);
        }

        return ret;
    }

    private List<List<Integer>> permuteIter(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();

        if(nums.length == 1) {
            ret.add(toList(nums));
            return ret;
        }

        Arrays.sort(nums);
        int n = nums.length;

        boolean work = true;
        do {
            ret.add(toList(nums));

            //next permutation
            int i = n - 1, j = n - 1;
            while(i > 0) {
                if(nums[i] > nums[i - 1]) {
                    while(j >= i) {
                        if(nums[j] > nums[i - 1]) {
                            swap(nums, i - 1, j);
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
                swap(nums, i++, j--);
            }
        }while(work);
        return ret;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        for(int n: nums) ret.add(n);
        return ret;
    }

    public static void main(String[] args) {
        Permutations c = new Permutations();
        int[] n = {1,2,3};
        c.permute(n);
    }
}
