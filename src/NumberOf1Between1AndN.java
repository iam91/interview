public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        return count(n, 5);
    }

    public int count(int n, int x) {
        int cnt = 0, k;
        for (int i = 1; (k = n / i) > 0; i *= 10) {
            // k / 10 为高位的数字。
            cnt += (k / 10) * i;
            // 当前位的数字。
            int cur = k % 10;
            if (cur > x) {
                cnt += i;
            } else if (cur == x) {
                // n - k * i 为低位的数字。
                cnt += (n - k * i) + 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN c = new NumberOf1Between1AndN();
        System.out.println(c.NumberOf1Between1AndN_Solution(2593));
    }
}
