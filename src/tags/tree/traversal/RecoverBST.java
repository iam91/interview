package tags.tree.traversal;

import tags.tree.TreeNode;

import java.util.Stack;

/**
 * Created by zwy on 18-4-11.
 */
public class RecoverBST {

    public void recoverTree(TreeNode root) {
        TreeNode n1 = null, n2 = null;
        TreeNode curr = root, prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if(prev != null) {
                if(n1 == null && curr.val < prev.val) {
                    n1 = prev;
                }

                if(n1 != null && curr.val < prev.val) {
                    n2 = curr;
                }
            }
            prev = curr;

            curr = curr.right;
        }

        if(n1 != null) {
            int t = n1.val;
            n1.val = n2.val;
            n2.val = t;
        }
    }

    public static void main(String[] args) {
        RecoverBST c = new RecoverBST();

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);

//        n0.left = n1;
//        n0.right = n2;

        n1.right = n0;
        n0.left = n2;

        c.recoverTree(n1);
    }
}
