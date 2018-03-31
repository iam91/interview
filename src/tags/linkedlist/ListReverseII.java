package tags.linkedlist;

import tags.tree.ListNode;

public class ListReverseII {
    // https://leetcode.com/problems/reverse-linked-list-ii/description/

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode curr = head;
        ListNode cut = null;

        int i = 1;
        while(i < m) {
            cut = curr;
            curr = curr.next;
            i++;
        }


        ListNode newTail = curr;
        ListNode pre = null;

        while(i <= n) {
            ListNode t = curr.next;
            curr.next = pre;
            pre = curr;
            curr = t;
            i++;
        }

        newTail.next = curr;
        if(cut != null) {
            cut.next = pre;
            return head;
        } else {
            return pre;
        }
    }
}
