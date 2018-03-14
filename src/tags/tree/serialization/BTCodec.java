package tags.tree.serialization;

import tags.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTCodec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return  "#";

        StringBuilder ret = new StringBuilder();

        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();

        while(curr != null || !s.isEmpty()) {
            while(curr != null) {
                s.push(curr);
                ret.append(curr.val + ",");
                curr = curr.left;
            }
            ret.append("#,");

            curr = s.pop();
            curr = curr.right;
        }

        return ret.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("#")) return null;

        String[] nodes = data.split(",");
        Queue<String> q = new LinkedList<>();
        for(String node: nodes) q.offer(node);

        return helper(q);
    }

    private TreeNode helper(Queue<String> q) {
        if(q.size() == 0) return null;

        String curr = q.poll();
        if(curr.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = helper(q);
        root.right = helper(q);

        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        // [1,2,3,null,null,4,5]

        BTCodec codec = new BTCodec();
        TreeNode root = codec.deserialize(codec.serialize(n1));
        int a = 1;
    }
}
