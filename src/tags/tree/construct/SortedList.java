package tags.tree.construct;

import tags.tree.ListNode;
import tags.tree.TreeNode;

public class SortedList {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    private TreeNode build(ListNode head, ListNode tail) {

        int cnt = 0;
        ListNode curr = head;
        while(curr != tail) {
            cnt++;
            curr = curr.next;
        }

        int mid = cnt / 2;
        curr = head;
        for(int i = 0; i < mid; i++) {
            curr = curr.next;
        }

        if(cnt > 0) {
            TreeNode root = new TreeNode(curr.val);
            root.left = build(head, curr);
            root.right = build(curr.next, tail);
            return root;
        } else return null;
    }

    public static void main(String[] args) {
        SortedList c = new SortedList();

        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        c.sortedListToBST(n1);

        int n = 0;
    }
}
