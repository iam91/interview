package leetcode.dp;

public class PalindromicSubstring {
    public int countSubstrings(String s) {
        // return extention(s);
        return dp(s);
    }

    private int dp(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        int cnt = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i =  0; i < n; i++) {
            dp[i][i] = true;
            cnt ++;
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 == j || dp[i + 1][j - 1]);
                if(dp[i][j]) cnt++;
            }
        }

        return cnt;
    }

    private int extention(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            cnt += extend(s, i, i);
            cnt += extend(s, i, i + 1);
        }

        return cnt;
    }

    private int extend(String s, int p, int q) {
        int n = s.length();
        int cnt = 0;
        while(p >= 0 && q < n) {
            if(s.charAt(p) == s.charAt(q)) {
                cnt++;
                p--;
                q++;
            } else break;
        }
        return cnt;
    }

    public static void main(String[] args) {
        PalindromicSubstring c = new PalindromicSubstring();
        System.out.println(c.countSubstrings("aaa"));
    }
}
