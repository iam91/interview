package tags.tree.traversal;

import tags.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Postorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new LinkedList<>();
        // recur(root, postorder);
        iter(root, postorder);
        return postorder;
    }

    private void recur(TreeNode root, List<Integer> postorder) {
        if(root == null) return;

        recur(root.left, postorder);
        recur(root.right, postorder);
        postorder.add(root.val);
    }

    private void iter(TreeNode root, List<Integer> postorder) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode lastVisit = null;
        while(curr != null || !stack.isEmpty()) {
            // left subtree
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            if(curr.right == null || curr.right == lastVisit) {
                // visit
                postorder.add(curr.val);
                lastVisit = curr;
                curr = null;
                stack.pop();
            } else {
                curr = curr.right;
            }
        }
    }
}
