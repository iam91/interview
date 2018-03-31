package tags.linkedlist;

import tags.tree.ListNode;

public class ListSwapPairs {
    // https://leetcode.com/problems/swap-nodes-in-pairs/description/

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode n1 = head;
        ListNode n2 = head.next;
        ListNode pre = null;

        head = null;
        while(n2 != null) {

            ListNode t = n2.next;
            n2.next = n1;
            n1.next = t;

            if(pre != null) {
                pre.next = n2;
            }
            pre = n1;
            if(head == null) head = n2;

            n1 = t;
            if(n1 == null) break;
            n2 = n1.next;
        }

        return head;
    }
}
