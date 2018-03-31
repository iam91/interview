package tags.linkedlist;

import tags.tree.ListNode;

public class ListRotate {
    // https://leetcode.com/problems/rotate-list/description/

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        // count and find tail
        ListNode tail = head;
        int n = 1;
        while(tail.next != null) {
            tail = tail.next;
            n++;
        }

        tail.next = head;

        ListNode curr = head;
        k = k % n;
        for(int i = 1; i <= n - k - 1; i++) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }
}
