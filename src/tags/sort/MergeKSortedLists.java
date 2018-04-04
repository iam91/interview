package tags.sort;

import tags.tree.ListNode;

public class MergeKSortedLists {
    // https://leetcode.com/problems/merge-k-sorted-lists/description/

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        lists[0] = merge(lists, 0, lists.length - 1);

        return lists[0];
    }

    private ListNode merge(ListNode[] lists, int i, int j) {
        if(i >= j) return lists[i];

        int mid = (i + j) / 2;
        lists[i] = merge(lists, i, mid);
        lists[mid + 1] = merge(lists, mid + 1, j);

        lists[i] = mergeTwoLists(lists[i], lists[mid + 1]);

        return lists[i];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
