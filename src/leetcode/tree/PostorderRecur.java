package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PostorderRecur {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        if(root == null) return ret;

        ret.addAll(postorderTraversal(root.left));
        ret.addAll(postorderTraversal(root.right));
        ret.add(root.val);

        return ret;
    }
}
