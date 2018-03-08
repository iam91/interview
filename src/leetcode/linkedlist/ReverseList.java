package leetcode.linkedlist;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        return iter(head);
        // return recur(head, null);
    }

    private ListNode iter(ListNode head) {
        if(head == null) return null;
        ListNode curr = head, prev = null;

        while(curr != null) {
            ListNode t = curr.next;

            curr.next = prev;
            prev = curr;
            curr = t;
        }

        return prev;
    }

    private ListNode recur(ListNode curr, ListNode prev) {
        if(curr == null) return null;

        ListNode t = curr.next;
        curr.next = prev;

        if(t == null) return curr;

        return recur(t, curr);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ReverseList c = new ReverseList();
        ListNode t = c.reverseList(n1);
        while(t != null) {
            System.out.println(t.val);
            t = t.next;
        }
    }
}
