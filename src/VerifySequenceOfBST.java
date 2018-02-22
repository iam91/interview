public class VerifySequenceOfBST {
    public boolean VerifySequenceOfBST(int [] sequence) {
        if(sequence == null) return false;
        if(sequence.length == 1) return true;
        boolean t = help(sequence, -1, sequence.length - 1);
        return t;
    }

    public boolean help(int[] sequence, int r, int l) {
        if(l == r) return false;
        if(l - 1 == r) return true;

        int root = sequence[l];
        int curr = l - 1;
        int moreR = curr;
        while(curr > r && sequence[curr] > root) {
            curr--;
        }
        int moreL = curr;
        int lessR = curr;
        while(curr > r && sequence[curr] < root) {
            curr--;
        }
        int lessL = curr;
        if(curr > r) return false;
        else {
            boolean left = true;
            boolean right = true;
            if(moreR > moreL) left = help(sequence, moreL, moreR);
            if(lessR > lessL) right = help(sequence, lessL, lessR);
            return left && right;
        }
    }

    public static void main(String[] args) {
        VerifySequenceOfBST c = new VerifySequenceOfBST();
        int[] a = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(c.VerifySequenceOfBST(a));
    }
}