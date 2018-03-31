package tags.linkedlist;

import tags.tree.ListNode;

public class ListReverse {
    // https://leetcode.com/problems/reverse-linked-list/description/

    public ListNode reverseList(ListNode head) {
        // return iter(head);
        return recur(head, null);
    }

    private ListNode iter(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode t = curr.next;
            curr.next = pre;
            pre = curr;
            curr = t;
        }

        return pre;
    }

    private ListNode recur(ListNode head, ListNode pre) {

        if(head == null) return pre;

        ListNode t = head.next;
        head.next = pre;

        return recur(t, head);
    }
}
