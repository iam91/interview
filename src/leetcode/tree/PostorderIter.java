package leetcode.tree;

import java.util.*;

public class PostorderIter {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> righted = new HashSet<>();

        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            if(righted.contains(curr)) {
                ret.add(curr.val);

                stack.pop();
                righted.remove(curr);
                curr = null;
            } else {
                righted.add(curr);
                curr = curr.right;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);

        r1.right = r2;
        r2.left = r3;

        PostorderIter c = new PostorderIter();
        for(Integer i: c.postorderTraversal(r1)) {
            System.out.println(i);
        }
    }
}
