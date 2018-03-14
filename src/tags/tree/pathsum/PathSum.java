package tags.tree.pathsum;

import tags.tree.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root, sum, 0);
    }

    private boolean helper(TreeNode root, int sum, int acc) {
        if(root.left == null && root.right == null) return sum == acc + root.val;

        return root.left != null && helper(root.left, sum, acc + root.val)
                || root.right != null && helper(root.right, sum, acc + root.val);
    }
}
