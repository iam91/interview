package tags.dp;

public class LPCS {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        int max = 0;
        int maxI = 0, maxJ = 0;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(i == j) dp[i][j] = 1;
                else if(s.charAt(i) == s.charAt(j)) {
                    if(i + 1 == j) dp[i][j] = 1;
                    else dp[i][j] = dp[i + 1][j - 1];
                } else dp[i][j] = 0;
                if(dp[i][j] > 0 && j - i > max) {
                    maxI = i;
                    maxJ = j;
                    max = j - i;
                }
            }
        }

        return s.substring(maxI, maxJ + 1);
    }
}
