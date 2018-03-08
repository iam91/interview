package leetcode.linkedlist;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        // 前进一轮
        ListNode slow = head.next, fast = head.next.next;

        while(slow != null && fast != null) {
            if(slow == fast) return true;
            if(fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
