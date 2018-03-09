package leetcode.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;

        ret.addAll(helper(root, sum, 0));
        for(List<Integer> path: ret) {
            Collections.reverse(path);
        }

        return ret;
    }

    private List<List<Integer>> helper(TreeNode root, int sum, int curr) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root.left == null && root.right == null) {
            if(sum == curr + root.val) {
                List<Integer> path = new LinkedList<>();
                path.add(root.val);
                ret.add(path);
            }
            return ret;
        }

        List<List<Integer>> left = new LinkedList<>();
        List<List<Integer>> right = new LinkedList<>();
        if(root.left != null) left.addAll(helper(root.left, sum, curr + root.val));
        if(root.right != null) right.addAll(helper(root.right, sum, curr + root.val));

        ret.addAll(left);
        ret.addAll(right);
        for(List<Integer> path: ret) {
            path.add(root.val);
        }

        return ret;
    }
}
