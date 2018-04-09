package tags.dp;

public class EditDistance {
    // https://leetcode.com/problems/edit-distance/description/

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if(n == 0) return m;
        if(m == 0) return n;

        int[][] dp = new int[n + 1][m + 1];

        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();

        for(int i = 0; i <= n; i++) dp[i][0] = i;
        for(int j = 0; j <= m; j++) dp[0][j] = j;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a[i - 1] == b[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        EditDistance c = new EditDistance();
        System.out.println(c.minDistance("a", "b"));
    }
}
