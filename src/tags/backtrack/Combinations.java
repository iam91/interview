package tags.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    // https://leetcode.com/problems/combinations/description/

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> comb = new LinkedList<>();
        List<List<Integer>> combines = new LinkedList<>();

        helper(n, k, 1, comb, combines);

        return combines;
    }

    private void helper(int n, int k, int curr, List<Integer> comb, List<List<Integer>> combines) {
        if(comb.size() == k) {
            List<Integer> temp = new LinkedList<>();
            temp.addAll(comb);
            combines.add(temp);
        } else {
            if(curr > n) return;

            comb.add(curr);
            helper(n, k, curr + 1, comb, combines);
            comb.remove((Integer)curr);
            helper(n, k, curr + 1, comb, combines);
        }
    }
}
