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

            // 遍历`左子树`
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            //回溯
            curr = stack.pop();

            // 遍历`当前节点`
            ret.add(curr.val);
            // 遍历`右子树`
            curr = curr.right;
        }

        return ret;
    }

}
