package leetcode.tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root, sum, 0);
    }

    private boolean helper(TreeNode root, int sum, int curr) {
        if(root.left == null && root.right == null) {
            return sum == curr + root.val;
        }

        boolean left = false;
        boolean right = false;
        if(root.left != null) left = helper(root.left, sum, curr + root.val);
        if(root.right != null) right = helper(root.right, sum, curr + root.val);

        return left || right;
    }
}
