public class ReConstructBinaryTree {

    private int[] pre;
    private int[] in;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        this.pre = pre;
        this.in = in;

        return help(0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode help(int preLeft, int preRight, int inLeft, int inRight) {
        TreeNode root = new TreeNode(pre[preLeft]);

        if(preLeft == preRight) return root;

        // find root in in order
        int inRootIdx = inLeft;
        while(inRootIdx <= inRight) {
            if(root.val == in[inRootIdx]) {
                break;
            } else {
                inRootIdx++;
            }
        }

        int leftLen = inRootIdx - inLeft;
        int rightLen = inRight - inLeft - leftLen;

        if(leftLen > 0)
            root.left = help(preLeft + 1, preLeft + leftLen, inLeft, inRootIdx - 1);
        if(rightLen > 0)
            root.right = help(preLeft + 1 + leftLen, preRight, inRootIdx + 1, inRight);

        return root;
    }

    public static void main(String[] args) {
        ReConstructBinaryTree c = new ReConstructBinaryTree();

        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
//        int[] pre = {1,2,4};
//        int[] in = {4,2,1};

        c.reConstructBinaryTree(pre, in);
    }
}
