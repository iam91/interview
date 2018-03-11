package tags.tree.traversal;

import tags.tree.TreeNode;

import java.util.*;

public class LevelorderUp {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // return topDown(root);
        return bottomUp(root);
    }

    private List<List<Integer>> topDown(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            ret.add(level);
        }

        Collections.reverse(ret);
        return ret;
    }

    private List<List<Integer>> bottomUp(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;

        SortedMap<Integer, List<Integer>> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        dfs(root, map, 0);

        while(!map.isEmpty()) {
            Integer lev = map.firstKey();
            ret.add(map.get(lev));
            map.remove(lev);
        }

        return ret;
    }

    private void dfs(TreeNode root, Map<Integer, List<Integer>> map, int level) {
        if(root == null) return;

        List<Integer> curr;
        if(map.containsKey(level)) {
            curr = map.get(level);
        } else {
            curr = new LinkedList<>();
            map.put(level, curr);
        }

        curr.add(root.val);
        dfs(root.left, map, level + 1);
        dfs(root.right, map, level + 1);
    }
}
