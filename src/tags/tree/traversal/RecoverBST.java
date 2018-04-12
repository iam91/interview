package tags.tree.traversal;

import tags.tree.TreeNode;

import java.util.Stack;

/**
 * Created by zwy on 18-4-11.
 */
public class RecoverBST {

    public void recoverTree(TreeNode root) {
        // inOrderMethod(root);
        morrisTraversalMethod(root);
    }

    private void morrisTraversalMethod(TreeNode root) {
        TreeNode n1 = null, n2 = null;
        TreeNode curr = root, prev = null;
        TreeNode t;
        while(curr != null) {
            if(prev != null && curr.val < prev.val) {
                if(n1 == null) n1 = prev;
                n2 = curr;
            }

            if(curr.left == null) {
                prev = curr;
                curr = curr.right;
            } else {
                t = curr.left;
                while(t.right != null && t.right != curr) {
                    t = t.right;
                }
                if(t.right == null) {
                    t.right = curr;
                    curr = curr.left;
                } else {
                    t.right = null;
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        if(n1 != null) {
            int tt = n1.val;
            n1.val = n2.val;
            n2.val = tt;
        }
    }

    private void inOrderMethod(TreeNode root) {
        TreeNode n1 = null, n2 = null;
        TreeNode curr = root, prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if(prev != null && curr.val < prev.val) {
                if(n1 == null) n1 = prev;
                n2 = curr;
            }
            prev = curr;

            curr = curr.right;
        }

        if(n1 != null) {
            int tt = n1.val;
            n1.val = n2.val;
            n2.val = tt;
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
