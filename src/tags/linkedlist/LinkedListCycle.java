package tags.linkedlist;

import tags.tree.ListNode;

public class LinkedListCycle {
    // https://leetcode.com/problems/linked-list-cycle/description/

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while(slow != null && fast != null) {
            if(slow == fast) return true;
            if(fast.next == null) return false;
            else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }

        return false;
    }
}
