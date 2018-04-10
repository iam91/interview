package tags.DivideConquer;

public class Sqrt {
    // https://leetcode.com/problems/sqrtx/description/

    public int mySqrt(int x) {
        if(x == 0) return 0;
        long i = 1, j = x / 2 + 1;
        while(i <= j) {
            long mid = (i + j) >> 1;
            long mul = mid * mid;
            if(mul == x) return (int)mid;
            else if(mul > x) j = mid - 1;
            else i = mid + 1;
        }

        return (int)j;
    }

    public static void main(String[] args) {
        Sqrt c = new Sqrt();

        int a = 2147395599;

        System.out.println(c.mySqrt(a));
    }
}
