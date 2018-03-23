package tags.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    // https://leetcode.com/problems/combination-sum-ii/description/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        LinkedList<Integer> comb = new LinkedList<>();
        List<List<Integer>> combines = new LinkedList<>();

        helper(candidates, target, 0, 0, combines, comb);

        return combines;
    }

    private void helper(int[] candidates, int target, int sum, int curr, List<List<Integer>> combines, LinkedList<Integer> comb) {
        if(sum == target) {
            List<Integer> temp = new LinkedList<>();
            temp.addAll(comb);
            combines.add(temp);
        } else if(sum < target) {

            if(curr >= candidates.length) return;

            int same = 1;
            int j = curr;
            while(j < candidates.length - 1) {
                if(candidates[j] != candidates[j + 1]) break;
                same++;
                j++;
            }
            helper(candidates, target, sum, curr + same, combines, comb);
            for(int i = curr; i < curr + same; i++) {
                comb.add(candidates[i]);
                sum += candidates[i];
                helper(candidates, target, sum, curr + same, combines, comb);
            }

            for(int i = curr; i < curr + same; i++) {
                comb.remove((Integer)candidates[i]);
            }
        }
    }
}
