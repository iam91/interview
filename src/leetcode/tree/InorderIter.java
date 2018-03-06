package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIter {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            ret.add(curr.val);
            curr = curr.right;
        }

        return ret;
    }

}
