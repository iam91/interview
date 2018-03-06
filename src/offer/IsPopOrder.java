package offer;

import java.util.*;

public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null) return false;
        if(pushA.length == 0 || popA.length == 0) return false;
        if(pushA.length != popA.length) return false;

        int size = pushA.length;

        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < size; i++) {
            q.offer(popA[i]);
        }
        for(int i = 0; i < size; i++) {

            if(pushA[i] != q.peek()) {
                s.push(pushA[i]);
            } else {
                q.poll();
                while(!s.isEmpty() && s.peek() == q.peek()) {
                    s.pop();
                    q.poll();
                }
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        IsPopOrder c = new IsPopOrder();

        int[] pushA = {1};
//        int[] popA = {4, 5, 3, 2, 1};
        int[] popA = {2};


        System.out.println(c.IsPopOrder(pushA, popA));
    }
}