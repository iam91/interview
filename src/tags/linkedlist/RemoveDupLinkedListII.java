package tags.linkedlist;

import tags.tree.ListNode;

import java.util.List;

public class RemoveDupLinkedListII {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while(curr != null) {

            boolean flag = false;
            while(curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
                flag = true;
            }

            if(flag) {
                if(pre == null) {
                    head = curr.next;
                    curr = head;
                } else {
                    pre.next = curr.next;
                    curr = curr.next;
                }
            } else {
                pre = curr;
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveDupLinkedListII c = new RemoveDupLinkedListII();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(c.deleteDuplicates(n1));
    }
}
