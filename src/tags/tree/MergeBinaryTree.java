package tags.tree;

public class MergeBinaryTree {
    // https://leetcode.com/problems/merge-two-binary-trees/description/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        else if(t1 != null && t2 != null) {
            t1.val += t2.val;
            t1.right = mergeTrees(t1.right, t2.right);
            t1.left = mergeTrees(t1.left, t2.left);
        } else {
            t1 = t1 == null ? t2 : t1;
        }
        return t1;
    }
}
