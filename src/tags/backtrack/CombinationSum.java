package tags.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    // https://leetcode.com/problems/combination-sum/description/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<Integer> comb = new LinkedList<>();
        List<List<Integer>> combines = new LinkedList<>();

        helper(candidates, target, 0, 0, combines, comb);
        return combines;
    }

    private void helper(int[] candidates, int target, int sum, int curr, List<List<Integer>> combines, List<Integer> comb) {
        if(target == sum) {
            List<Integer> temp = new LinkedList<>();
            temp.addAll(comb);
            combines.add(temp);
        } else if(target > sum) {
            if(curr < candidates.length) {
                helper(candidates, target, sum, curr + 1, combines, comb);
                int times = 0;
                while(sum < target) {
                    sum += candidates[curr];
                    times++;
                    comb.add(candidates[curr]);
                    helper(candidates, target, sum, curr + 1, combines, comb);
                }
                while(times-- > 0) comb.remove((Integer)candidates[curr]);
            }
        }
    }
}
