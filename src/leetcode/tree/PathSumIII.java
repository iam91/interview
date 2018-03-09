package leetcode.tree;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class PathSumIII {
    private int cnt = 0;

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        Deque<Integer> path = new LinkedList<>();
        path.offerLast(0);
        helper(root, sum, path);
        return cnt;
    }

    public void helper(TreeNode root, int sum, Deque<Integer> path) {

        Integer accumulate = path.peekLast() + root.val;
        Iterator<Integer> iter = path.iterator();
        while(iter.hasNext()) {
            if(accumulate - iter.next() == sum) {
                cnt++;
            }
        }

        if(root.left == null && root.right == null) {
            return;
        }

        path.offerLast(accumulate);
        if(root.left != null) helper(root.left, sum, path);
        if(root.right != null) helper(root.right, sum, path);
        path.pollLast();
    }
}
