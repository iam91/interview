package leetcode.tree;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
public class PreorderIter {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {

            // 遍历当前节点及其右子树
            while(curr != null) {
                ret.add(curr.val);
                stack.add(curr);
                curr = curr.left;
            }

            // 回溯
            curr = stack.pop();
            curr = curr.right;
        }

        return ret;
    }
}
