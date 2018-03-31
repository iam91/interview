package tags.random;

import tags.tree.ListNode;

import java.util.Random;

public class LinkedListRandomNode {
    // https://leetcode.com/problems/linked-list-random-node/description/

    private ListNode head;
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {

        Random rand = new Random();
        ListNode curr = this.head;
        int i = 1;
        int ret = curr.val;
        while(curr != null) {

            int r = rand.nextInt(i);
            if(r == 0) ret = curr.val;
            curr = curr.next;
            i++;
        }

        return ret;
    }
}
