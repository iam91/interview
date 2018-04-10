package tags.DivideConquer;

public class Pow {
    // https://leetcode.com/problems/sort-colors/submissions/1

    public double myPow(double x, int n) {

        if(n < 0) {
            return 1 / (helper(x, -(n + 1)) * x);
        } else {
            return helper(x, n);
        }
    }

    private double helper(double x, int n) {
        if(n == 0) return 1.0;
        double v = helper(x, n >> 1);
        if((n & 0x01) > 0) return v * v * x;
        else return v * v;
    }

    public static void main(String[] args) {
        Pow c = new Pow();

        int a = -2147483648;

        System.out.println(c.myPow(1.0, -2147483648));
    }
}
