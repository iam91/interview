package tags.tree;

import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree {
    // https://leetcode.com/problems/symmetric-tree/description/

    public boolean isSymmetric(TreeNode root) {
        // return iter(root);
        return recur(root, root);
    }

    private boolean recur(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        else if(root1 != null && root2 != null && root1.val == root2.val) {
            return recur(root1.left, root2.right) && recur(root1.right, root2.left);
        }
        else return false;
    }

    private boolean iter(TreeNode root) {
        Deque<TreeNode> left = new LinkedList<>();
        Deque<TreeNode> right = new LinkedList<>();

        left.offerFirst(root);
        right.offerLast(root);

        while(!left.isEmpty()) {
            if(left.size() != right.size()) return false;
            int n = left.size();

            for(int i = 0; i < n; i++) {
                TreeNode currLeft = left.pollFirst();
                TreeNode currRight = right.pollLast();

                if(currLeft != null && currRight != null && currLeft.val != currRight.val) return false;
                else if(currLeft == null && currRight != null) return false;
                else if(currLeft != null && currRight == null) return false;

                if(currLeft != null) {
                    left.offerLast(currLeft.left);
                    left.offerLast(currLeft.right);
                }

                if(currRight != null) {
                    right.offerFirst(currRight.right);
                    right.offerFirst(currRight.left);
                }
            }
        }

        return true;
    }
}
