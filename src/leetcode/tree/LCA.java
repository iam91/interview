package leetcode.tree;

public class LCA {
    private boolean found;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        found = false;
        return helper(root, p, q);
    }

//    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null) return null;
//
//        TreeNode left = helper(root.left, p, q);
//        TreeNode right = helper(root.right, p, q);
//
//        if(found) {
//            return left == null ? right : left;
//        } else {
//            if(left != null && right != null) {
//                found = true;
//                return root;
//            }
//            if(root.val == p.val || root.val == q.val) {
//                if(left != null || right != null) found = true;
//                return root;
//            }
//            return left == null ? right : left;
//        }
//    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        if(left != null && right !=  null) return root;
        if(root == p || root == q) return root;
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        LCA c = new LCA();
        System.out.println(c.lowestCommonAncestor(t1, t1, t2).val);
    }
}
