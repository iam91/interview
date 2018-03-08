package leetcode.linkedlist;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head.next, fast = head.next.next;
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
            fast = fast.next.next;
            slow = slow.next;
        }

        return null;
    }
}
