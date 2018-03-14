package tags.tree.lca;

import tags.tree.TreeNode;

public class BTLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null
                || root == q || root == p) return root;
        else return left == null ? right : left;
    }
}
