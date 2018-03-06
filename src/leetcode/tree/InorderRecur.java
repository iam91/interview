package leetcode.tree;

import java.util.List;
import java.util.ArrayList;
public class InorderRecur {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        if(root == null) return ret;
        ret.addAll(inorderTraversal(root.left));
        ret.add(root.val);
        ret.addAll(inorderTraversal(root.right));

        return ret;
    }
}
