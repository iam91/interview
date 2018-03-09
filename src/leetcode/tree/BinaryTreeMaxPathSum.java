package leetcode.tree;

public class BinaryTreeMaxPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        left = Math.max(0, left);
        right = Math.max(0, right);

        max = Math.max(max, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
