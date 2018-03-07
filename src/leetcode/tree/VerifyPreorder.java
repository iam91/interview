package leetcode.tree;

import java.util.Stack;

public class VerifyPreorder {
    public boolean isValidSerialization(String preorder) {
        return verifyII(preorder);
    }

    private boolean verify(String preorder) {
        if(preorder == null || preorder.length() == 0) return false;

        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();

        int i = 0;
        int n = nodes.length;
        String s = nodes[i++];

        while(!s.equals("#") || !stack.isEmpty()) {
            while(!s.equals("#")) {

                stack.push(s);
                if(i >= n) return false;
                s = nodes[i++];
            }

            stack.pop();

            if(i >= n) return false;
            String right = nodes[i++];

            s = right;
        }

        if(i < n) return false;
        else return true;
    }

    private boolean verifyII(String preorder) {
        if(preorder == null || preorder.length() == 0) return false;
        String[] nodes = preorder.split(",");

        int in = 0;
        int out = 1;

        for(int i = 0; i < nodes.length; i++) {
            in++;
            if(out < in) return false;
            if(!nodes[i].equals("#")) out += 2;
        }

        return in == out;
    }

    public static void main(String[] args) {
        VerifyPreorder c = new VerifyPreorder();
        System.out.println(c.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
