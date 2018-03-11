package tags.tree.traversal;

import tags.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if(root == null) return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
                if(i == n - 1) ret.add(curr.val);
            }
        }
        return ret;
    }
}
