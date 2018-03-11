package tags.tree.construct;

import tags.tree.TreeNode;

public class InPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if(postLeft > postRight) return null;

        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);

        int leftCnt = 0, rightCnt = 0;
        int i = inLeft;
        while(i <= inRight) {
            if(inorder[i] == rootVal) {
                rightCnt = inRight - inLeft - leftCnt;
                break;
            } else {
                leftCnt++;
                i++;
            }
        }

        root.left = build(inorder, postorder, inLeft, i - 1, postLeft, postLeft + leftCnt - 1);
        root.right = build(inorder, postorder, i + 1, inRight, postRight - rightCnt, postRight - 1);

        return root;
    }
}
