package leetcode.linkedlist;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n == m) return head;

        ListNode curr = head, prev = null, p = null;

        int i = 1;
        while(i < m) {
            i++;
            prev = curr;
            curr = curr.next;
        }
        p = prev;

        prev = null;
        ListNode t;
        while(i <= n) {
            t = curr.next;

            // do reverse
            curr.next = prev;

            prev = curr;
            curr = t;
            i++;
        }

        if(p == null) {
            head.next = curr;
            return prev;
        } else {
            p.next.next = curr;
            p.next = prev;
            return head;
        }
    }

    public static void main(String[] args) {
        ReverseBetween c = new ReverseBetween();
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        n1.next = n2;
        ListNode t = c.reverseBetween(n1, 1, 2);
    }
}
