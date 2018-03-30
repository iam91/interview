package tags.tree.pathsum;

import tags.tree.TreeNode;

public class MaxPathSum {
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

    private int globalMax;

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        globalMax = Integer.MIN_VALUE;
        helper(root);

        return globalMax;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        int subMax = Math.max(leftSum, rightSum);
        int ret = Math.max(subMax + root.val, root.val);

        globalMax = Math.max(globalMax, Math.max(ret, leftSum + rightSum + root.val));

        return ret;
    }
}
