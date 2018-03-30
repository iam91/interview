package tags.linkedlist;

import tags.tree.ListNode;

public class LinkedListCycleII {
    // https://leetcode.com/problems/linked-list-cycle-ii/description/

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while(slow != null && fast != null) {
            if(slow == fast) {
                // to find entry
                fast = head;
                while(fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
            if(fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }

        return null;
    }
}
