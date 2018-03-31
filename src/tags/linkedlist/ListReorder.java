package tags.linkedlist;

import tags.tree.ListNode;

public class ListReorder {
    // https://leetcode.com/problems/reorder-list/description/

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        // find the mid point
        ListNode cut = head.next;
        ListNode curr = head.next.next;
        while(curr != null && curr.next != null) {
            cut = cut.next;
            curr = curr.next.next;
        }
        curr = cut.next;
        if(curr == null) return;
        cut.next = null;

        // reverse the remaining half
        ListNode pre = null;
        while(curr != null) {
            ListNode t = curr.next;
            curr.next = pre;
            pre = curr;
            curr = t;
        }

        // reorder
        curr = head;
        while(curr != null && pre != null) {
            ListNode tCurr = curr.next;
            ListNode tPre = pre.next;

            curr.next = pre;
            pre.next = tCurr;

            curr = tCurr;
            pre = tPre;
        }
    }
}
