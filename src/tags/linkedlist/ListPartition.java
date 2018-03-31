package tags.linkedlist;

import tags.tree.ListNode;

public class ListPartition {
    // https://leetcode.com/problems/partition-list/description/

    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode curr = head;

        ListNode lessHead, lessTail, moreHead, moreTail;
        lessHead = lessTail = moreHead = moreTail = null;

        while(curr != null) {
            if(curr.val < x) {
                if(lessHead == null) {
                    lessHead = lessTail = curr;
                } else {
                    lessTail.next = curr;
                    lessTail = lessTail.next;
                }
            } else {
                if(moreHead == null) {
                    moreHead = moreTail = curr;
                } else {
                    moreTail.next = curr;
                    moreTail = moreTail.next;
                }
            }

            curr = curr.next;
            if(lessTail != null) lessTail.next = null;
            if(moreTail != null) moreTail.next = null;
        }

        if(lessTail != null) {
            lessTail.next = moreHead;
            return lessHead;
        } else return moreHead;
    }

    public static void main(String[] args) {
        ListPartition c = new ListPartition();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        c.partition(n1, 3);
    }
}
