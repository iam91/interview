package tags.linkedlist;

import tags.tree.ListNode;

public class IntersectionNode {
    // http://www.lintcode.com/zh-cn/problem/intersection-of-two-linked-lists/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        int cntA = 0, cntB = 0;
        ListNode a = headA, b = headB;
        while(a != null) {
            cntA++;
            a = a.next;
        }
        while(b != null) {
            cntB++;
            b = b.next;
        }

        ListNode longer, shorter;
        longer = cntA > cntB ? headA : headB;
        shorter = cntA > cntB ? headB : headA;

        int more = Math.abs(cntA - cntB);
        while(more-- > 0) {
            longer = longer.next;
        }

        while(longer != null && shorter != null && longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
    }
}
