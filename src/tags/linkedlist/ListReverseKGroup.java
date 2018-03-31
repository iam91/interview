package tags.linkedlist;

import tags.tree.ListNode;

public class ListReverseKGroup {
    // https://leetcode.com/problems/reverse-nodes-in-k-group/description/

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode cut = null;
        while(curr != null) {
            int i = 1;
            ListNode t = curr;
            while(i <= k && t != null) {
                t = t.next;
                i++;
            }
            if(i <= k) break;

            ListNode pre = null;
            ListNode tail = curr;
            while(curr != t) {
                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            }

            if(cut == null) head = pre;
            else cut.next = pre;

            tail.next = curr;
            cut = tail;
        }

        return head;
    }
}
