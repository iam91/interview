package leetcode.tree;

public class BuildFromInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, inorder, 0, postorder.length, 0, inorder.length);
    }

    public TreeNode build(int[] postorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pl >= pr) return null;

        int rootVal = postorder[pr - 1];
        TreeNode root = new TreeNode(rootVal);

        int rightCnt = 0;
        for(int i = ir - 1; i >= il; i--) {
            if(inorder[i] != rootVal) rightCnt++;
            else break;
        }

        int leftCnt = ir - il - rightCnt - 1;

        root.left = build(postorder, inorder, pl, pl + leftCnt,
                il, il + leftCnt);
        root.right = build(postorder, inorder, pl + leftCnt, pl + leftCnt + rightCnt,
                il + leftCnt + 1, il + leftCnt + 1 + rightCnt);

        return root;
    }
}
