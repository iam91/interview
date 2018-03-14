package tags.dp;

public class PalindromicSubstr {
    public int countSubstrings(String s) {
        // return dp(s);
        return extension(s);
    }

    public int dp(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        int cnt = 0;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(i == j) dp[i][j] = 1;
                else if(s.charAt(i) == s.charAt(j)) {
                    if(i + 1 == j) dp[i][j] = 1;
                    else dp[i][j] = dp[i + 1][j - 1];
                } else dp[i][j] = 0;
                cnt += dp[i][j];
            }
        }

        return cnt;
    }

    public int extension(String s) {
        int n = s.length();

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            cnt += extend(s, i, i) + extend(s, i, i + 1);
        }

        return cnt;
    }

    private int extend(String s, int i, int j) {
        int cnt = 0;
        while(i >= 0 && j < s.length()) {
            if(s.charAt(i--) == s.charAt(j++)) cnt++;
            else break;
        }
        return cnt;
    }
}
