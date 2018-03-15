package tags.dp;

import tags.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class UniqueBSTII {
    //https://leetcode.com/problems/unique-binary-search-trees-ii/description/
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> ret = new LinkedList<>();

        if(l == r) {
            TreeNode root = new TreeNode(l);
            ret.add(root);
            return ret;
        }

        for(int i = l; i <= r; i++) {

            List<TreeNode> left = helper(l, i - 1);
            List<TreeNode> right = helper(i + 1, r);

            if(left.size() == 0 && right.size() > 0) {
                for(TreeNode node: right) {
                    TreeNode root = new TreeNode(i);
                    root.right = node;
                    ret.add(root);
                }
            } else if(right.size() == 0 && left.size() > 0) {
                for(TreeNode node: left) {
                    TreeNode root = new TreeNode(i);
                    root.left = node;
                    ret.add(root);
                }
            } else if(left.size() > 0 && right.size() > 0) {
                for(TreeNode node1: left) {
                    for(TreeNode node2: right) {
                        TreeNode root = new TreeNode(i);
                        root.left = node1;
                        root.right = node2;
                        ret.add(root);
                    }
                }
            } else {
                TreeNode root = new TreeNode(i);
                ret.add(root);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        UniqueBSTII c = new UniqueBSTII();

        List<TreeNode> r = c.generateTrees(3);
    }
}
