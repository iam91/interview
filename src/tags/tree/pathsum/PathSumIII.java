package tags.tree.pathsum;

import tags.tree.TreeNode;

import java.util.Iterator;
import java.util.Stack;

public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        Stack<Integer> acc = new Stack<>();
        acc.push(0);
        return helper(root, sum, acc);
    }

    private int helper(TreeNode root, int sum, Stack<Integer> acc) {

        Integer last = acc.peek() + root.val;
        Iterator<Integer> iter = acc.iterator();
        int cnt = 0;
        while(iter.hasNext()) {
            if(last - iter.next() == sum) cnt++;
        }

        acc.push(last);
        if(root.left != null) cnt += helper(root.left, sum, acc);
        if(root.right != null) cnt += helper(root.right, sum, acc);
        acc.pop();
        return cnt;
    }
}
