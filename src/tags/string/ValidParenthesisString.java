package tags.string;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParenthesisString {
    // https://leetcode.com/problems/valid-parenthesis-string/description/

    public boolean checkValidString(String s) {
        int n = s.length();
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> star = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '*') {
                star.addLast(i);
            } else if(ch == '(') {
                left.addLast(i);
            } else if(ch == ')') {
                if(!left.isEmpty()) {
                    left.pollLast();
                } else {
                    if(star.isEmpty()) return false;
                    else star.pollLast();
                }
            }
        }

        while(!left.isEmpty()) {
            Integer currLeft = left.pollFirst();

            while(!star.isEmpty() && star.peekFirst() <= currLeft) {
                star.pollFirst();
            }

            if(star.isEmpty()) return false;
            else star.pollFirst();
        }

        return true;
    }
}
