package leetcode.tree;

public class BuildFromInPre {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pl >= pr) return null;

        int rootVal = preorder[pl];
        TreeNode root = new TreeNode(rootVal);

        // 左子树集合
        int leftCnt = 0;
        for(int i = il; i < ir; i++) {
            if(inorder[i] != rootVal) leftCnt++;
            else break;
        }

        // 右子树集合
        int rightCnt = ir - il - leftCnt - 1;


        root.left = build(preorder, inorder, pl + 1, pl + 1 + leftCnt,
                il, il + leftCnt);
        root.right = build(preorder, inorder, pl + 1 + leftCnt, pl + 1 + leftCnt + rightCnt,
                il + leftCnt + 1, il + leftCnt + 1 + rightCnt);

        return root;
    }
}
