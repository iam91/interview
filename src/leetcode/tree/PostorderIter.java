package leetcode.tree;

import java.util.*;

public class PostorderIter {
    public List<Integer> postorderTraversalII(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode lastVisit = null;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            if(curr.right == null || curr.right == lastVisit) {
                stack.pop();
                ret.add(curr.val);
                lastVisit = curr;
                curr = null;
            } else {
                curr = curr.right;
            }
        }

        return ret;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> righted = new HashSet<>();

        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {

            // 遍历 `左子树`
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 回溯
            curr = stack.peek();
            if(righted.contains(curr)) {
                // 遍历 `当前节点`
                ret.add(curr.val);

                stack.pop();
                righted.remove(curr);
                curr = null;
            } else {
                // 遍历 `右子树`
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
