package tags.backtrack;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    // https://leetcode.com/problems/combination-sum-iii/description/

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> comb = new LinkedList<>();
        List<List<Integer>> combines = new LinkedList<>();

        helper(k, n, 0, 1, combines, comb);

        return combines;
    }

    private void helper(int k, int n, int sum, int curr, List<List<Integer>> combines, List<Integer> comb) {
        if(comb.size() == k && sum == n) {
            List<Integer> temp = new LinkedList<>();
            temp.addAll(comb);
            combines.add(temp);
        } else if(comb.size() < k && sum < n) {

            if(curr > 9) return;

            comb.add(curr);
            helper(k, n, sum + curr, curr + 1, combines, comb);
            comb.remove((Integer)curr);
            helper(k, n, sum, curr + 1, combines, comb);
        }
    }
}
