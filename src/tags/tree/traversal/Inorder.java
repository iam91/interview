package tags.tree.traversal;

import tags.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new LinkedList<>();
        // recur(root, inorder);
        iter(root, inorder);
        return inorder;
    }

    public void recur(TreeNode root, List<Integer> inorder) {
        if(root == null) return;

        recur(root.left, inorder);
        inorder.add(root.val);
        recur(root.right, inorder);
    }

    public void iter(TreeNode root, List<Integer> inorder) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            // left subtree
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            // visit
            inorder.add(curr.val);
            // right subtree
            curr = curr.right;
            stack.pop();
        }
    }
}
