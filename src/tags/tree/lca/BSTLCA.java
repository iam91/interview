package tags.tree.lca;

import tags.tree.TreeNode;

public class BSTLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val > q.val) {
            TreeNode t = p;
            p = q;
            q = t;
        }
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root == q
                || root.val > p.val && root.val < q.val) return root;

        if(root.val < p.val) return helper(root.right, p, q);
        if(root.val > q.val) return helper(root.left, p, q);
        return null;
    }
}
