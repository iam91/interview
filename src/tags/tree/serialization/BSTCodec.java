package tags.tree.serialization;

import tags.tree.TreeNode;

public class BSTCodec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder series = new StringBuilder();
        serializeHelper(root, series);
        return series.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder s) {
        if(root == null) return;
        s.append(root.val + ",");
        serializeHelper(root.left, s);
        serializeHelper(root.right, s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] ss = data.split(",");
        int[] vals = new int[ss.length];
        for(int i = 0; i < vals.length; i++) {
            vals[i] = Integer.parseInt(ss[i]);
        }
        return deserializeHelper(vals, 0, vals.length -1);
    }

    private TreeNode deserializeHelper(int[] vals, int l, int r) {
        if(l > r) return null;
        int rootVal = vals[l];
        TreeNode root = new TreeNode(rootVal);
        if(l == r) return root;

        int i = l + 1;
        while(i <= r && vals[i] < rootVal) {
            i++;
        }
        int leftCnt = i - l;
        int rightCnt = r - i + 1;
        root.left = deserializeHelper(vals, l + 1, i - 1);
        root.right = deserializeHelper(vals, i, r);
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n2.left = n1;
        n2.right = n3;

        BSTCodec codec = new BSTCodec();
        TreeNode root = codec.deserialize(codec.serialize(n2));
        int a = 1;
    }
}
