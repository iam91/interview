package tags.tree.traversal;

import tags.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new LinkedList<>();
        // recur(root, preorder);
        iter(root, preorder);
        return preorder;
    }

    private void recur(TreeNode root, List<Integer> preorder) {
        if(root == null) return;

        preorder.add(root.val);
        recur(root.left, preorder);
        recur(root.right, preorder);
    }

    private void iter(TreeNode root, List<Integer> preorder) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            // left subtree
            while(curr != null) {
                // visit
                preorder.add(curr.val);

                stack.push(curr);
                curr = curr.left;
            }

            // backtrack
            curr = stack.peek();

            //right subtree
            curr = curr.right;
            stack.pop();
        }
    }
}
