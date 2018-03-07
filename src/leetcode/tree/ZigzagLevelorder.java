package leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelorder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()) {
            int size = q.size();

            TreeNode curr;
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                if(flag) curr = q.pollFirst();
                else curr = q.pollLast();

                level.add(curr.val);
                if(flag) {
                    if(curr.left != null) q.offerLast(curr.left);
                    if(curr.right != null) q.offerLast(curr.right);
                } else {
                    if(curr.right != null) q.offerFirst(curr.right);
                    if(curr.left != null) q.offerFirst(curr.left);
                }
            }
            ret.add(level);
            flag = !flag;
        }

        return ret;
    }
}
