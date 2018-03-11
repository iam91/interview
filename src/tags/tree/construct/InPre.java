package tags.tree.construct;

import tags.tree.TreeNode;

public class InPre {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft > preRight) return null;

        int rootVal = preorder[preLeft];
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

        root.left = build(preorder, inorder, preLeft + 1, preLeft + leftCnt, inLeft, i - 1);
        root.right = build(preorder, inorder, preRight - rightCnt + 1, preRight, i + 1, inRight);

        return root;
    }
}
