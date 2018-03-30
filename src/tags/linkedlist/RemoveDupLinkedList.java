package tags.linkedlist;

import tags.tree.ListNode;

public class RemoveDupLinkedList {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while(curr != null) {
            if(curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }

        return head;
    }
}
