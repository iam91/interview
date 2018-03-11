package tags.tree.traversal;

import tags.tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelorder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false;
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }

            if(reverse) Collections.reverse(level);
            reverse = !reverse;

            ret.add(level);
        }

        return ret;
    }
}
