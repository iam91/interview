package tags.tree.pathsum;

import tags.tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = helper(root, sum, 0);
        for(List<Integer> path: ret) {
            Collections.reverse(path);
        }
        return ret;
    }

    private List<List<Integer>> helper(TreeNode root, int sum, int acc) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;
        if(root.left == null && root.right == null) {
            if(sum == acc + root.val) {
                List<Integer> path = new LinkedList<>();
                path.add(root.val);
                ret.add(path);
            }
        } else {
            ret.addAll(helper(root.left, sum, acc + root.val));
            ret.addAll(helper(root.right, sum, acc + root.val));
            for(List<Integer> path: ret) {
                path.add(root.val);
            }
        }
        return ret;
    }
}
