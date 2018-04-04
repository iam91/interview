package tags.sort;

import tags.tree.ListNode;

public class MergeTwoSortedLists {

    // https://leetcode.com/problems/merge-two-sorted-lists/description/

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(l1 != null || l2 != null) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if(val1 < val2) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        return head.next;
    }
}
